package ua.edu.sumdu.j2se.studentName.tasks;

import static ua.edu.sumdu.j2se.studentName.tasks.ListTypes.types.ARRAY;
import static ua.edu.sumdu.j2se.studentName.tasks.ListTypes.types.LINKED;

public abstract class AbstractTaskList
{
    public abstract void add(Task task);
    public abstract boolean remove(Task task);
    public abstract int size();
    public abstract Task getTask(int index);

    public AbstractTaskList incoming(int from, int to)
    {
        AbstractTaskList abstractTaskList;

        if ( (this.getClass()).getSimpleName() == "ArrayTaskList")
        {
            abstractTaskList = TaskListFactory.createTaskList(ARRAY);
        }
        else
        {
            abstractTaskList = TaskListFactory.createTaskList(LINKED);
        }

        for (int i = 0; i < size(); i++)
        {
            if (this.getTask(i).nextTimeAfter(from) != -1 && this.getTask(i).nextTimeAfter(from) < to)
            {
                abstractTaskList.add(this.getTask(i));
            }
        }
        
        return abstractTaskList;
    }
}
