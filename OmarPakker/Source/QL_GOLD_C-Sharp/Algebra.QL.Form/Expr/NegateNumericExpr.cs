﻿using System;
using Algebra.Core.Expr;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
	public class NegateNumericExpr : UnaryExpr<IFormExpr>, IFormExpr
	{
        public event Action ValueChanged
        {
            add { Expr1.ValueChanged += value; }
            remove { Expr1.ValueChanged -= value; }
        }

		public NegateNumericExpr(IFormExpr expr)
            : base(expr)
		{
            
		}

        public void SetValue(VarEnvironment env, object value)
        {
            Expr1.SetValue(env, -Convert.ToDouble(value));
        }

        public object Eval(VarEnvironment env)
        {
            return -Convert.ToDouble(Expr1.Eval(env));
        }

        public IFormType BuildForm(VarEnvironment env)
        {
            IFormType type = Expr1.BuildForm(env);
            type.SetElementExpression(this);

            return type;
        }
    }
}