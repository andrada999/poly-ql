﻿using System.Collections.Generic;
using QL.QLClasses.Expressions;
using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Statements
{
    public class StatementIf : StatementBase
    {
        public ExpressionBase Condition { get; set; }
        public List<StatementBase> Body { get; set; }
        public StatementIf ElseIfStatement { get; set; }

        public StatementIf()
        {
            Body = new List<StatementBase>();
        }

        public override bool CheckType(ref QLException error)
        {
            //when else statement, condition is null
            if (Condition != null)
            {
                if (!Condition.CheckType(ref error))
                    return false;

                if (!(Condition.GetResultType() is QBool))
                {
                    error.Message = string.Format("Condition is not a boolean. Got QType '{0}', with valuetype '{1}'", Condition, Condition.GetResultType());
                    error.TokenInfo = Condition.TokenInfo;
                    
                    return false;
                }
            }
            
            foreach (StatementBase statement in Body)
            {
                if (!statement.CheckType(ref error))
                    return false;
            }

            if (ElseIfStatement != null)
                return ElseIfStatement.CheckType(ref error);

            return true;
        }
    }
}
