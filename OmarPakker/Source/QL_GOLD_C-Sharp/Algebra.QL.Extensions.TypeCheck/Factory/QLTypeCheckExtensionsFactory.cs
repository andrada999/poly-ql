﻿using System;
using Algebra.QL.Extensions.Factory;
using Algebra.QL.Extensions.TypeCheck.Expr;
using Algebra.QL.Extensions.TypeCheck.Expr.Literals;
using Algebra.QL.Extensions.TypeCheck.Stmnt;
using Algebra.QL.Extensions.TypeCheck.Type;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Factory;
using Algebra.QL.TypeCheck.Stmnt;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.Extensions.TypeCheck.Factory
{
    public class QLTypeCheckExtensionsFactory : QLTypeCheckFactory, IQLExtensionsFactory<ITypeCheckExpr, ITypeCheckStmnt, ITypeCheckType>
    {
        public QLTypeCheckExtensionsFactory()
        {

        }

        public ITypeCheckType DateType()
        {
            return new DateType();
        }

		public ITypeCheckExpr Date(DateTime date)
		{
            return new DateLiteral(date);
		}

        public ITypeCheckExpr Modulo(ITypeCheckExpr l, ITypeCheckExpr r)
        {
            return new ModuloExpr(l, r);
        }

        public ITypeCheckExpr Power(ITypeCheckExpr l, ITypeCheckExpr r)
        {
            return new PowerExpr(l, r);
        }

		public ITypeCheckStmnt Loop(ITypeCheckExpr e, ITypeCheckStmnt s)
		{
			return new LoopStmnt(e, s);
		}
	}
}
