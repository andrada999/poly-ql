﻿using QL.QLClasses.Types;
using QL.QLClasses.Values;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Identifier
{
    public class QIdentifier : ExpressionBase
    {
        private readonly QLMemoryManager _memory;
        private readonly string _name;

        public QIdentifier(QLMemoryManager memoryManager, string name)
        {
            _memory = memoryManager;
            _name = name;
        }

        public override QType GetResultType()
        {
            return _memory.GetDeclaredType(_name);
        }

        public override QValue Evaluate()
        {
            return _memory.GetDeclaredValue(_name).Evaluate();
        }

        #region TypeChecker Implementation

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            if (!_memory.IsDeclared(_name))
            {
                typeErrors.ReportError(new QLTypeError
                {
                    Message = string.Format("Referenced identifier '{0}' is not defined!", _name),
                    TokenInfo = TokenInfo
                });
                return false;
            }

            return true;
        }

        #endregion
    }
}