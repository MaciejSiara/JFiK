// Generated from MyGrammar.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MyGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, PRINT=4, READ=5, REPEAT=6, ENDREPEAT=7, FUNCTION=8, 
		ENDFUNCTION=9, TOINT=10, TOREAL=11, STRING=12, ID=13, REAL=14, INT=15, 
		MULTIPLY=16, DIVIDE=17, SUBTRACT=18, ADD=19, NEWLINE=20, WS=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "PRINT", "READ", "REPEAT", "ENDREPEAT", "FUNCTION", 
			"ENDFUNCTION", "TOINT", "TOREAL", "STRING", "ID", "REAL", "INT", "MULTIPLY", 
			"DIVIDE", "SUBTRACT", "ADD", "NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'('", "')'", "'drukuj'", "'czytaj'", "'powtorz'", "'koniecpowtorz'", 
			"'funkcja'", "'koniecfunkcja'", "'(int)'", "'(real)'", null, null, null, 
			null, "'*'", "'/'", "'-'", "'+'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "PRINT", "READ", "REPEAT", "ENDREPEAT", "FUNCTION", 
			"ENDFUNCTION", "TOINT", "TOREAL", "STRING", "ID", "REAL", "INT", "MULTIPLY", 
			"DIVIDE", "SUBTRACT", "ADD", "NEWLINE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public MyGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MyGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u00ac\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\7\r}\n\r\f\r\16\r\u0080\13\r\3\r\3\r\3\16\6\16\u0085"+
		"\n\16\r\16\16\16\u0086\3\17\6\17\u008a\n\17\r\17\16\17\u008b\3\17\3\17"+
		"\6\17\u0090\n\17\r\17\16\17\u0091\3\20\6\20\u0095\n\20\r\20\16\20\u0096"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\5\25\u00a2\n\25\3\25\3\25"+
		"\3\26\6\26\u00a7\n\26\r\26\16\26\u00a8\3\26\3\26\2\2\27\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27\3\2\5\4\2$$^^\4\2C\\c|\5\2\13\f\17\17\"\"\2\u00b2\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5/\3\2\2\2"+
		"\7\61\3\2\2\2\t\63\3\2\2\2\13:\3\2\2\2\rA\3\2\2\2\17I\3\2\2\2\21W\3\2"+
		"\2\2\23_\3\2\2\2\25m\3\2\2\2\27s\3\2\2\2\31z\3\2\2\2\33\u0084\3\2\2\2"+
		"\35\u0089\3\2\2\2\37\u0094\3\2\2\2!\u0098\3\2\2\2#\u009a\3\2\2\2%\u009c"+
		"\3\2\2\2\'\u009e\3\2\2\2)\u00a1\3\2\2\2+\u00a6\3\2\2\2-.\7?\2\2.\4\3\2"+
		"\2\2/\60\7*\2\2\60\6\3\2\2\2\61\62\7+\2\2\62\b\3\2\2\2\63\64\7f\2\2\64"+
		"\65\7t\2\2\65\66\7w\2\2\66\67\7m\2\2\678\7w\2\289\7l\2\29\n\3\2\2\2:;"+
		"\7e\2\2;<\7|\2\2<=\7{\2\2=>\7v\2\2>?\7c\2\2?@\7l\2\2@\f\3\2\2\2AB\7r\2"+
		"\2BC\7q\2\2CD\7y\2\2DE\7v\2\2EF\7q\2\2FG\7t\2\2GH\7|\2\2H\16\3\2\2\2I"+
		"J\7m\2\2JK\7q\2\2KL\7p\2\2LM\7k\2\2MN\7g\2\2NO\7e\2\2OP\7r\2\2PQ\7q\2"+
		"\2QR\7y\2\2RS\7v\2\2ST\7q\2\2TU\7t\2\2UV\7|\2\2V\20\3\2\2\2WX\7h\2\2X"+
		"Y\7w\2\2YZ\7p\2\2Z[\7m\2\2[\\\7e\2\2\\]\7l\2\2]^\7c\2\2^\22\3\2\2\2_`"+
		"\7m\2\2`a\7q\2\2ab\7p\2\2bc\7k\2\2cd\7g\2\2de\7e\2\2ef\7h\2\2fg\7w\2\2"+
		"gh\7p\2\2hi\7m\2\2ij\7e\2\2jk\7l\2\2kl\7c\2\2l\24\3\2\2\2mn\7*\2\2no\7"+
		"k\2\2op\7p\2\2pq\7v\2\2qr\7+\2\2r\26\3\2\2\2st\7*\2\2tu\7t\2\2uv\7g\2"+
		"\2vw\7c\2\2wx\7n\2\2xy\7+\2\2y\30\3\2\2\2z~\7$\2\2{}\n\2\2\2|{\3\2\2\2"+
		"}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0081\3\2\2\2\u0080~\3\2\2"+
		"\2\u0081\u0082\7$\2\2\u0082\32\3\2\2\2\u0083\u0085\t\3\2\2\u0084\u0083"+
		"\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\34\3\2\2\2\u0088\u008a\4\62;\2\u0089\u0088\3\2\2\2\u008a\u008b\3\2\2"+
		"\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f"+
		"\7\60\2\2\u008e\u0090\4\62;\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2"+
		"\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\36\3\2\2\2\u0093\u0095"+
		"\4\62;\2\u0094\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097 \3\2\2\2\u0098\u0099\7,\2\2\u0099\"\3\2\2\2\u009a"+
		"\u009b\7\61\2\2\u009b$\3\2\2\2\u009c\u009d\7/\2\2\u009d&\3\2\2\2\u009e"+
		"\u009f\7-\2\2\u009f(\3\2\2\2\u00a0\u00a2\7\17\2\2\u00a1\u00a0\3\2\2\2"+
		"\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\7\f\2\2\u00a4*\3"+
		"\2\2\2\u00a5\u00a7\t\4\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\b\26"+
		"\2\2\u00ab,\3\2\2\2\n\2~\u0086\u008b\u0091\u0096\u00a1\u00a8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}