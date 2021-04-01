package net.rkoubou.dddcommons;

import java.util.Date;
import java.util.Objects;

public class DateValue implements ValueObject<Date>, Comparable<DateValue>
{
    protected final Date value;

    public DateValue( Date value )
    {
        this.value = value;
    }

    @Override
    public Date get()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return value.toString();
    }

    @Override
    public boolean equals( Object other )
    {
        if( this == other )
        {
            return true;
        }
        if( other == null || getClass() != other.getClass() )
        {
            return false;
        }
        DateValue dateValue = (DateValue)other;
        return Objects.equals( value, dateValue.value );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( value );
    }

    @Override
    public int compareTo( DateValue other )
    {
        return value.compareTo( other.value );
    }
}
