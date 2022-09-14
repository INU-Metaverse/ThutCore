/*****************************************************************************
 * JEP - Java Math Expression Parser 2.3.1
 * January 26 2006
 * (c) Copyright 2004, Nathan Funk and Richard Morris
 * See LICENSE.txt for license information.
 *****************************************************************************/
package org.nfunk.jep.function;

import java.util.Stack;

import org.nfunk.jep.ParseException;
import org.nfunk.jep.type.Complex;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ArcSine extends PostfixMathCommand
{
    public ArcSine()
    {
        this.numberOfParameters = 1;

    }

    public Object asin(Object param) throws ParseException
    {
        if (param instanceof Complex) return ((Complex) param).asin();
        else if (param instanceof Number) return Double.valueOf(Math.asin(((Number) param).doubleValue()));

        throw new ParseException("Invalid parameter type");
    }

    @Override
    public void run(Stack inStack) throws ParseException
    {
        this.checkStack(inStack);// check the stack
        final Object param = inStack.pop();
        inStack.push(this.asin(param));// push the result on the inStack
        return;
    }

}
