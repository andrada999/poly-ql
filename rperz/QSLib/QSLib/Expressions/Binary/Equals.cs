﻿using QSLib.Types;
using QSLib.Expressions.Values;
using System.ComponentModel;
namespace QSLib.Expressions.Binary
{
    class Equals : Binary_Expression
    {

        public Equals(QSExpression a, QSExpression b, int linenr)
            : base(a, b, linenr)
        {
            base._operator = "==";
        }

        public override Value Evaluate()
        {
            this._value = this._left.Evaluate().EqualTo(this._right.Evaluate());
            this.OnPropertyChanged("GetValue");
            return this._value;
        }
        
        public override QSType Type
        {
            get { return new BoolType(); }
        }
    }
}
