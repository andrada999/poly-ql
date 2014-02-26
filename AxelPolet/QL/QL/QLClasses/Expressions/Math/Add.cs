﻿using System;
using QL.QLClasses.Expressions.Literals;
using QL.QLClasses.Types;

namespace QL.QLClasses.Expressions.Math
{
    public class Add : MathExpression
    {
        public override ExpressionBase GetResult()
        {
            //return Convert.ToInt32(LeftValue.GetResult()) + Convert.ToInt32(RightValue.GetResult());
            return new IntLiteral(Convert.ToInt32(LeftValue.GetResult()) + Convert.ToInt32((RightValue.GetResult())));
        }
    }
}
