
import java.util.HashMap;
import java.util.Stack;

enum VarType{ INT, REAL, UNKNOWN, VARIABLE }

class Value{
    public String name;
    public VarType type;
    public Value( String name, VarType type ){
        this.name = name;
        this.type = type;
    }
}

public class LLVMActions extends MyGrammarBaseListener {

    HashMap<String, VarType> variables = new HashMap<String, VarType>();
    Stack<Value> stack = new Stack<Value>();

    @Override
    public void exitAssign(MyGrammarParser.AssignContext ctx) {
        String ID = ctx.ID().getText();
        Value v = stack.pop();
        variables.put(ID, v.type);
        if( v.type == VarType.INT ){
            LLVMGenerator.declare_i32(ID);
            LLVMGenerator.assign_i32(ID, v.name);
        }
        if( v.type == VarType.REAL ){
            LLVMGenerator.declare_double(ID);
            LLVMGenerator.assign_double(ID, v.name);
        }
    }

    @Override
    public void exitProg(MyGrammarParser.ProgContext ctx) {
        System.out.println( LLVMGenerator.generate() );
    }

    @Override
    public void exitInt(MyGrammarParser.IntContext ctx) {
        stack.push( new Value(ctx.INT().getText(), VarType.INT) );
    }

    @Override
    public void exitReal(MyGrammarParser.RealContext ctx) {
        stack.push( new Value(ctx.REAL().getText(), VarType.REAL) );
    }

    @Override
    public void exitVariable(MyGrammarParser.VariableContext ctx) {
        stack.push( new Value(ctx.ID().getText(), VarType.VARIABLE) );
    }

    @Override
    public void exitAddExpression(MyGrammarParser.AddExpressionContext ctx) {
        Value v1 = stack.pop();
        Value v2 = stack.pop();
        if(v1.type == VarType.VARIABLE){
            VarType varType1 = variables.get(v1.name);
            if(v2.type == VarType.VARIABLE ){
                VarType varType2 = variables.get(v1.name);
                if(varType1 == varType2){
                    if (varType1 == VarType.INT) {
                        LLVMGenerator.add_vars_i32(v1.name, v2.name);
                        stack.push(new Value("%" + (LLVMGenerator.reg - 1), VarType.INT));
                    }
                    if (varType1 == VarType.REAL) {
                        LLVMGenerator.add_vars_double(v1.name, v2.name);
                        stack.push(new Value("%" + (LLVMGenerator.reg - 1), VarType.REAL));
                    }
                }
            } else if(varType1 == v2.type) {
                if (varType1 == VarType.INT) {
                    LLVMGenerator.add_i32_var(v1.name, v2.name);
                    stack.push(new Value("%" + (LLVMGenerator.reg - 1), VarType.INT));
                }
                if (varType1 == VarType.REAL) {
                    LLVMGenerator.add_double_var(v1.name, v2.name);
                    stack.push(new Value("%" + (LLVMGenerator.reg - 1), VarType.REAL));
                }
            }else {
                error(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),"add type mismatch");
            }
        } else if(v2.type == VarType.VARIABLE){
            VarType varType = variables.get(v2.name);
            if(varType == v1.type) {
                if (varType == VarType.INT) {
                    LLVMGenerator.add_i32_var(v2.name, v1.name);
                    stack.push(new Value("%" + (LLVMGenerator.reg - 1), VarType.INT));
                }
                if (varType == VarType.REAL) {
                    LLVMGenerator.add_double_var(v2.name, v1.name);
                    stack.push(new Value("%" + (LLVMGenerator.reg - 1), VarType.REAL));
                }
            }else {
                error(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),"add type mismatch");
            }
        }
        else if( v1.type == v2.type ) {
            if( v1.type == VarType.INT ){
                LLVMGenerator.add_i32(v1.name, v2.name);
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT) );
            }
            if( v1.type == VarType.REAL ){
                LLVMGenerator.add_double(v1.name, v2.name);
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.REAL) );
            }
        } else {
            error(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),"add type mismatch");
        }
    }

    @Override
    public void exitSubExpression(MyGrammarParser.SubExpressionContext ctx) {
        Value v1 = stack.pop();
        Value v2 = stack.pop();
        if(v1.type == VarType.VARIABLE){
            VarType varType1 = variables.get(v1.name);
            if(v2.type == VarType.VARIABLE ){
                VarType varType2 = variables.get(v1.name);
                if(varType1 == varType2){
                    if (varType1 == VarType.INT) {
                        LLVMGenerator.sub_vars_i32(v1.name, v2.name);
                        stack.push(new Value("%" + (LLVMGenerator.reg - 1), VarType.INT));
                    }
                    if (varType1 == VarType.REAL) {
                        LLVMGenerator.sub_vars_double(v1.name, v2.name);
                        stack.push(new Value("%" + (LLVMGenerator.reg - 1), VarType.REAL));
                    }
                }
            } else if(varType1 == v2.type) {
                if (varType1 == VarType.INT) {
                    LLVMGenerator.sub_i32_var(v1.name, v2.name, 0);
                    stack.push(new Value("%" + (LLVMGenerator.reg - 1), VarType.INT));
                }
                if (varType1 == VarType.REAL) {
                    LLVMGenerator.sub_double_var(v1.name, v2.name, 0);
                    stack.push(new Value("%" + (LLVMGenerator.reg - 1), VarType.REAL));
                }
            }else {
                error(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),"add type mismatch");
            }
        } else if(v2.type == VarType.VARIABLE){
            VarType varType = variables.get(v2.name);
            if(varType == v1.type) {
                if (varType == VarType.INT) {
                    LLVMGenerator.sub_i32_var(v2.name, v1.name, 1);
                    stack.push(new Value("%" + (LLVMGenerator.reg - 1), VarType.INT));
                }
                if (varType == VarType.REAL) {
                    LLVMGenerator.sub_double_var(v2.name, v1.name, 1);
                    stack.push(new Value("%" + (LLVMGenerator.reg - 1), VarType.REAL));
                }
            }else {
                error(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),"add type mismatch");
            }
        } else if( v1.type == v2.type ) {
            if( v1.type == VarType.INT ){
                LLVMGenerator.sub_i32(v2.name, v1.name);
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT) );
            }
            if( v1.type == VarType.REAL ){
                LLVMGenerator.sub_double(v2.name, v1.name);
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.REAL) );
            }
        } else {
            error(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),"add type mismatch");
        }
    }

    @Override
    public void exitMulExpression(MyGrammarParser.MulExpressionContext ctx) {
        Value v1 = stack.pop();
        Value v2 = stack.pop();
        if( v1.type == v2.type ) {
            if( v1.type == VarType.INT ){
                LLVMGenerator.mul_i32(v1.name, v2.name);
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT) );
            }
            if( v1.type == VarType.REAL ){
                LLVMGenerator.mul_double(v1.name, v2.name);
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.REAL) );
            }
        } else {
            error(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),"mult type mismatch");
        }
    }

    @Override
    public void exitDivExpression(MyGrammarParser.DivExpressionContext ctx) {
        Value v1 = stack.pop();
        Value v2 = stack.pop();
        if( v1.type == v2.type ) {
            if( v1.type == VarType.INT ){
                LLVMGenerator.div_i32(v1.name, v2.name);
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT) );
            }
            if( v1.type == VarType.REAL ){
                LLVMGenerator.div_double(v1.name, v2.name);
                stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.REAL) );
            }
        } else {
            error(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),"mult type mismatch");
        }
    }

    @Override
    public void exitToint(MyGrammarParser.TointContext ctx) {
        Value v = stack.pop();
        if(v.type == VarType.VARIABLE){
            LLVMGenerator.fptosi_var( v.name );
        }else{
            LLVMGenerator.fptosi( v.name );
        }
        stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.INT) );
    }

    @Override
    public void exitToreal(MyGrammarParser.TorealContext ctx) {
        Value v = stack.pop();

        if(v.type == VarType.VARIABLE){
            LLVMGenerator.sitofp_var( v.name );
        }else{
            LLVMGenerator.sitofp( v.name );
        }
        stack.push( new Value("%"+(LLVMGenerator.reg-1), VarType.REAL) );
    }

    @Override
    public void exitPrint(MyGrammarParser.PrintContext ctx) {
        String ID = ctx.ID().getText();
        VarType type = variables.get(ID);
        if( type != null ) {
            if( type == VarType.INT ){
                LLVMGenerator.printf_i32( ID );
            }
            if( type == VarType.REAL ){
                LLVMGenerator.printf_double( ID );
            }
        } else {
            error(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),"unknown variable "+ID);
        }
    }



    @Override
    public void exitRead(MyGrammarParser.ReadContext ctx) {
        String ID = ctx.ID().getText();
        if( ! variables.containsKey(ID) ) {
            variables.put(ID, VarType.INT);
            LLVMGenerator.declare_i32(ID);
        }
        LLVMGenerator.scanf(ID);
    }

    void error(int line, int column, String msg){
        System.err.println("Error, line:"+line+", column:"+column+" "+msg);
        System.exit(1);
    }

}
