﻿using QSLib.Types;
using QSLib.Values;

namespace QSLib.AST.Expressions.Binary
{
    class And : Binary_Expression
    {
        public And(QSExpression a, QSExpression b, int lineNr)
            : base(a, b, lineNr)
        {
            base._operator = "&&";
        }

        public override Value Evaluate()
        {
            this._value = this._left.Evaluate().And(this._right.Evaluate());
            this.OnPropertyChanged("GetValue");
            return this._value;
        }

        public override QSType Type
        {
            get { return new BoolType(); }
        }
    }
}
