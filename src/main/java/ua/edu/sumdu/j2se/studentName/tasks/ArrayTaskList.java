package ua.edu.sumdu.j2se.studentName.tasks;

public class ArrayTaskList extends AbstractTaskList
{
    private int size = 10;
    private Task [] TaskList = new Task[size];
    private int current = 0;

    public void add(Task task)
    {
        if(task == null)
        {
            throw new NullPointerException();
        }
        else
        {
            if(current == TaskList.length-1)
            {
                riseTaskList();
            }
            TaskList[current] = task;
            current++;
        }
    }

    private void riseTaskList()
    {
        Task [] tempTaskList = new Task[TaskList.length*2];
        System.arraycopy(TaskList, 0, tempTaskList, 0, current);
        TaskList = tempTaskList;
    }

    public boolean remove(Task task)
    {
        if(task == null)
        {
            throw new NullPointerException();
        }
        else {
            boolean t = false;

            for (int i = 0; i < current; i++)
            {
                if (TaskList[i] == task)
                {
                    for(int j = i; j < current-1; j++)
                    {
                        TaskList[j] = TaskList[j+1];
                    }
                    TaskList[current-1] = null;
                    t = true;
                    current--;
                }
            }
            if (t == true)
            {
                return true;
            } else {
                return false;
            }
        }
    }

    public int size()
    {
        return current;
    }

    public Task getTask(int index)
    {
        if(index > current)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            return TaskList[index];
        }
    }
}

























