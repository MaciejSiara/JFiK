// Generated from MyGrammar.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyGrammarParser}.
 */
public interface MyGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(MyGrammarParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(MyGrammarParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link MyGrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign(MyGrammarParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link MyGrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign(MyGrammarParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code print}
	 * labeled alternative in {@link MyGrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrint(MyGrammarParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code print}
	 * labeled alternative in {@link MyGrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrint(MyGrammarParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code read}
	 * labeled alternative in {@link MyGrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterRead(MyGrammarParser.ReadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code read}
	 * labeled alternative in {@link MyGrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitRead(MyGrammarParser.ReadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueExpr}
	 * labeled alternative in {@link MyGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterValueExpr(MyGrammarParser.ValueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueExpr}
	 * labeled alternative in {@link MyGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitValueExpr(MyGrammarParser.ValueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link MyGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpression(MyGrammarParser.AddExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link MyGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpression(MyGrammarParser.AddExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divExpression}
	 * labeled alternative in {@link MyGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivExpression(MyGrammarParser.DivExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divExpression}
	 * labeled alternative in {@link MyGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivExpression(MyGrammarParser.DivExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subExpression}
	 * labeled alternative in {@link MyGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubExpression(MyGrammarParser.SubExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subExpression}
	 * labeled alternative in {@link MyGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubExpression(MyGrammarParser.SubExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulExpression}
	 * labeled alternative in {@link MyGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulExpression(MyGrammarParser.MulExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulExpression}
	 * labeled alternative in {@link MyGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulExpression(MyGrammarParser.MulExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensExpression}
	 * labeled alternative in {@link MyGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void enterParensExpression(MyGrammarParser.ParensExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensExpression}
	 * labeled alternative in {@link MyGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void exitParensExpression(MyGrammarParser.ParensExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code toint}
	 * labeled alternative in {@link MyGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void enterToint(MyGrammarParser.TointContext ctx);
	/**
	 * Exit a parse tree produced by the {@code toint}
	 * labeled alternative in {@link MyGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void exitToint(MyGrammarParser.TointContext ctx);
	/**
	 * Enter a parse tree produced by the {@code toreal}
	 * labeled alternative in {@link MyGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void enterToreal(MyGrammarParser.TorealContext ctx);
	/**
	 * Exit a parse tree produced by the {@code toreal}
	 * labeled alternative in {@link MyGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void exitToreal(MyGrammarParser.TorealContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link MyGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void enterInt(MyGrammarParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link MyGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void exitInt(MyGrammarParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code real}
	 * labeled alternative in {@link MyGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void enterReal(MyGrammarParser.RealContext ctx);
	/**
	 * Exit a parse tree produced by the {@code real}
	 * labeled alternative in {@link MyGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void exitReal(MyGrammarParser.RealContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variable}
	 * labeled alternative in {@link MyGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void enterVariable(MyGrammarParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variable}
	 * labeled alternative in {@link MyGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void exitVariable(MyGrammarParser.VariableContext ctx);
}