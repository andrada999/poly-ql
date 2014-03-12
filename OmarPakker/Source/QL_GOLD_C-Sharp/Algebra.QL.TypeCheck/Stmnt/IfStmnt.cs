﻿using System;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Stmnt
{
	public class IfStmnt : IfStmnt<ITypeCheckExpr, ITypeCheckStmnt>, ITypeCheckStmnt
    {
		private static readonly ITypeCheckType ExpressionType = new BoolType();
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }

		public IfStmnt(ITypeCheckExpr check, ITypeCheckStmnt ifTrue)
            : base(check, ifTrue)
		{

		}

        public void TypeCheck(TypeEnvironment env, ErrorReporter errRep)
        {
            if (!CheckExpression.TypeCheck(env, errRep).CompatibleWith(ExpressionType))
            {
                errRep.ReportError(this, "Unable to evaluate 'if'. Expression must be of type bool!");
            }

            IfTrueBody.TypeCheck(env, errRep);
        }
    }
}