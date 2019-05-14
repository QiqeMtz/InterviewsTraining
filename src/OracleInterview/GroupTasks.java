package OracleInterview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/*
10:40:00, Task1, Started

10:41:00, Task2, Started

10:45:00, Task1, Finished

10:47:00, Task3, Started

10:50:00, Task3, Finished

11:00:00, Task2, Finished

11:15:00, Task4, Started

11:20:00, Task4, Finished

----------- OUTPUT -----------

10:40:00 - 10:41:00 : Task1,

10:41:00 - 10:45:00 : Task1 (5), Task2

10:45:00 - 10:47:00 : Task2 **** not added task2

10:47:00 - 10:50:00 : Task2, Task3 (3) ** not task 2

10:50:00 - 11:00:00 : Task2 (19)

11:00:00 - 11:15:00 : Free

11:15:00 - 11:20:00 : Task4 (5)
 */
public class GroupTasks {

    public static void main(String[] args) throws IOException, ParseException {
        groupTasks();
    }

    static class Task implements Comparable<Task> {
        String startTime;
        String endTime;
        String taskName;
        String taskStatus;
        String timeDifference;

        public Task(String time, String taskName, String taskStatus) {
            this.startTime = time;
            this.endTime = null;
            this.taskName = taskName;
            this.taskStatus = taskStatus;
            this.timeDifference = null;
        }

        @Override
        public int compareTo(Task other) {
            return startTime.compareTo(other.startTime);
        }

    }

    static void groupTasks() throws IOException, ParseException {
        BufferedReader reader;
        HashMap<String, Task> taskMap = new HashMap<>();
        HashMap<String, List<String>> groupedTask = new HashMap<>();

        reader = new BufferedReader(new FileReader("test.txt"));

        String strLine = reader.readLine();

        while(strLine != null) {
            String[] fields = strLine.split(", ");

            if (!groupedTask.containsKey(fields[0])) {
                groupedTask.put(fields[0], null);
            }

            if(taskMap.containsKey(fields[1])) {
                String timeDifference = calculateDiff(taskMap.get(fields[1]).startTime, fields[0]);
                taskMap.get(fields[1]).endTime = fields[0];
                taskMap.get(fields[1]).timeDifference = timeDifference;
            } else {
                taskMap.put(fields[1], new Task(fields[0], fields[1], fields[2]));
            }
            strLine = reader.readLine();
        }

        Object[] timeKeys = groupedTask.keySet().toArray();
        Arrays.sort(timeKeys);

        groupedTask.clear();

        for(int i = 1; i < timeKeys.length; i++) {
            groupedTask.put(timeKeys[i-1] + " - " + timeKeys[i], new ArrayList<>());
        }

        Object[] keyGroups = groupedTask.keySet().toArray();
        Arrays.sort(keyGroups);

        List<Task> tasks = new ArrayList<>(taskMap.values());
        Collections.sort(tasks);

        for(Task t: tasks) {
            for(Object key : keyGroups) {
                String startTime = key.toString().substring(0, 8);
                String endTime = key.toString().substring(11, key.toString().length());

                if(startTime.contains(t.startTime)) {
                    List<String> tempList = groupedTask.get(key.toString());
                    tempList.add(t.taskName);
                    groupedTask.put(key.toString(), tempList);
                }
                if(key.toString().contains("- " + t.endTime)) {
                    List<String> tempList = groupedTask.get(key.toString());
                    if(tempList.contains(t.taskName)) {
                        tempList.remove(t.taskName);
                    }
                    tempList.add(t.taskName + " (" + t.timeDifference + ")");
                    groupedTask.put(key.toString(), tempList);
                }
            }
        }

        for(String key : groupedTask.keySet()){
            List<String> temp = groupedTask.get(key);
            if(temp.isEmpty()){
                temp.add("Free");
                groupedTask.put(key, temp);
            }
        }

        for(Object key : keyGroups) {
            String print = key + " : ";
            for(String str : groupedTask.get(key)) {
                print = print + str + ", ";
            }
            print = print.substring(0, print.length()-2);
            System.out.println(print);
        }

    }

    private static String calculateDiff(String startTime, String endTime) {
        DateFormat dateFormat = new SimpleDateFormat ("HH:mm:ss");
        Date start = new Date();
        Date end = new Date();
        try {
            start = dateFormat.parse(startTime);
            end = dateFormat.parse(endTime);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        long milisecTime = end.getTime() - start.getTime();

        return String.valueOf(TimeUnit.MILLISECONDS.toMinutes(milisecTime));
    }

}

