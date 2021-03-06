﻿using QL.QLClasses;

namespace QL
{
    partial class QLParser
    {
        private Questionnaire _ASTRoot;
        private QLMemory _qlMemory;

        public void SetIdManager(QLMemory qlMemory)
        {
            _qlMemory = qlMemory;
        }

        public Questionnaire GetAST()
        {
            return _ASTRoot;
        }
    }
}
