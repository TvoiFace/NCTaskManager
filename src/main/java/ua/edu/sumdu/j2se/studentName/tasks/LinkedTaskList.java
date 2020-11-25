package ua.edu.sumdu.j2se.studentName.tasks;

public class LinkedTaskList extends AbstractTaskList
{
    private Node first;
    private Node last;
    private int size;

    private class Node
    {
        private Task task; //Двусвязный список
        private Node previous;
        private Node next;

        private Node(Task task)
        {
            this.task = task;

            if(first == null)
            {
                first = this;
            }
            else
            {
                previous = last;
                previous.next = this;
            }

            last = this;
        }
    }

    public void add(Task task)
    {
        if(task == null)
        {
            throw new NullPointerException();
        }
        else
        {
            Node node = new Node(task);
            size++;
        }
    }

    public void setSize(int size)
    {
        if(size < 0)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            this.size = size;
        }
    }

    public boolean remove(Task task)
    {
        if(task == null)
        {
            throw new NullPointerException();
        }
        else
        {
            Node temp = first;

            do
            {
                if(temp.task == task)
                {
                    if(temp == first)
                    {
                        first = first.next;
                        first.previous = null;
                        size--;
                        return true;
                    }
                    else if(temp == last)
                    {
                        last = last.previous;
                        last.next = null;
                        size--;
                        return true;
                    }
                    else
                    {
                        temp.next.previous = temp.previous;
                        temp.previous.next = temp.next;
                        temp = null;
                        size--;
                        return true;
                    }
                }
                temp = temp.next;
            }while(temp != null);

            return false;
        }
    }

    public int size()
    {
        return size;
    }

    public Task getTask(int index)
    {
        if(index > size)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            Node temp = first;

            if (temp == null)
            {
                return null;
            }
            else
            {
                for (int i = 0; i < index; i++)
                {
                    temp = temp.next;
                }

                return temp.task;
            }
        }
    }
}
