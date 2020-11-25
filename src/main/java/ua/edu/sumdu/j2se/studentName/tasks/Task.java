package ua.edu.sumdu.j2se.studentName.tasks;

public class Task
{
    private String title;
    private int time;
    private int start;
    private int end;
    private int interval;
    private  boolean active;

    public Task(String title, int time)
    {
        if(time < 0)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            this.title = title;
            this.time = time;
        }
    }

    public Task(String title, int start, int end, int interval)
    {
        if(start < 0 || end < 0 || interval <= 0 || start > end)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            this.title = title;
            this.start = start;
            this.end = end;
            this.interval = interval;
        }
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public boolean isActive()
    {
       return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public int getTime()
    {
        if(isRepeated())
        {
            return start;
        }
        else
        {
            return time;
        }
    }

    public void setTime(int time)
    {
        if(time < 0)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            if (!isRepeated())
            {
                start = 0;
                end = 0;
                interval = 0;
            }
            else
            {
                this.time = time;
            }
        }
    }

    public int getStartTime()
    {
        if(!isRepeated())
        {
            return time;
        }
        else
        {
            return start;
        }
    }

    public int getEndTime()
    {
        if(!isRepeated())
        {
            return time;
        }
        else
        {
            return end;
        }
    }

    public int getRepeatInterval()
    {
        if(!isRepeated())
        {
            return 0;
        }
        else
        {
            return interval;
        }
    }

    public void setTime(int start, int end, int interval)
    {
        if(start < 0 || end < 0 || interval <= 0 || start > end)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            if (!isRepeated()) {
                this.time = 0;
            } else {
                this.start = start;
                this.end = end;
                this.interval = interval;
            }
        }
    }

    public boolean isRepeated()
    {
        if(time == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int nextTimeAfter(int current) {
        if (current < 0)
        {
            throw new IllegalArgumentException();
        }
        else {
            if (!active) {
                return -1;
            } else if (isRepeated()) {
                if (end - current < 0) {
                    return -1;
                } else if (start - current > 0) {
                    return start;
                } else {
                    int nextTime = 0;

                    for (int i = start; i < end; i += interval) {
                        if (i + interval > end) {
                            nextTime = -1;
                            break;
                        } else if (i - current > 0 && i - current <= interval) {
                            nextTime = i;
                            break;
                        }
                    }

                    return nextTime;
                }
            } else {
                if (time - current > 0) {
                    return time;
                } else {
                    return -1;
                }
            }
        }
    }
}




























