﻿using System;
using Algebra.Core.Environment;
using Algebra.QL.Extensions.Environment;
using Algebra.QL.TypeCheck.Environment;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.Extensions.TypeCheck.Environment
{
    public class TypeEnvironment : ExtVarEnvironment<ITypeCheckType>, ITypeEnvironment
    {
        private readonly ErrorManager errorManager;

        public TypeEnvironment(ErrorManager errorMngr)
            : base()
        {
            errorManager = errorMngr;
        }

        public void ReportError(string msg, Tuple<int, int> startPos, Tuple<int, int> endPos)
        {
            errorManager.ReportError(msg, startPos, endPos);
        }

        public void ReportWarning(string msg, Tuple<int, int> startPos, Tuple<int, int> endPos)
        {
            errorManager.ReportWarning(msg, startPos, endPos);
        }
    }
}
