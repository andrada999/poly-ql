﻿using Antlr4.Runtime;
using QL.QLClasses.Values;
using QL.TypeChecker;

namespace QL.QLClasses.Types
{
    public class QString : QType
    {
        public override QType GetType()
        {
            return this;
        }

        public override string ToString()
        {
            return "QString";
        }

        public override QValue UndefinedValue()
        {
            return new StringValue("");
        }

        #region TypeChecker Implementation

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            return true;
        }

        #endregion

        #region Double Dispatch Implementation

        public override bool IsCompatibleWith(QType type)
        {
            return type.IsCompatibleWithQString(this);
        }

        public override bool IsCompatibleWithQString(QString type)
        {
            return true;
        }

        #endregion
    }
}
