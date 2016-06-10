/* 
 * Copyright (C) 2014 svene_000
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package construction.Operators;

import construction.Types.IType;
import construction.Types.IntType;
import construction.Values.IntValue;
import construction.Values.Value;

import java.util.Map;

public class Minus extends BinaryOperator {

    public Minus(Expression leftHandExpression, Expression rightHandExpression, int line) {
        super(leftHandExpression, rightHandExpression, line);
    }

    public String toString() {
        return "Left Hand: " + leftHandExpression.toString() + " Right Hand: " + rightHandExpression.toString();
    }

    @Override
    public IType getType(Map<String, IType> map) {
        return new IntType();
    }

    @Override
    public Value getValue(Map<String, Value> map) {
        IntValue lhv = (IntValue) leftHandExpression.getValue(map);
        IntValue rhv = (IntValue) rightHandExpression.getValue(map);
        return new IntValue(lhv.getIntValue() - rhv.getIntValue());
    }
}