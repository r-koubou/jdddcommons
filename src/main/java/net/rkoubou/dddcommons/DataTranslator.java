package net.rkoubou.dddcommons;

public interface DataTranslator<TSource, TTarget>
{
    TTarget translate( TSource source );
}
