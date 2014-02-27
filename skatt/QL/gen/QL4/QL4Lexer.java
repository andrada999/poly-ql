// Generated from grammar/QL4.g4 by ANTLR 4.2

  package QL4;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QL4Lexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__18=1, T__17=2, T__16=3, T__15=4, T__14=5, T__13=6, T__12=7, T__11=8, 
		T__10=9, T__9=10, T__8=11, T__7=12, T__6=13, T__5=14, T__4=15, T__3=16, 
		T__2=17, T__1=18, T__0=19, LABEL=20, COMMENT=21, TYPE=22, IF=23, ELSEIF=24, 
		ELSE=25, BOOLEAN=26, IDENTIFIER=27, STRING=28, DEC=29, INT=30, WS=31;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"')'", "'+'", "'-'", "'*'", "'('", "':'", "'<'", "'!='", "';'", "'<='", 
		"'&&'", "'||'", "'{'", "'>'", "'/'", "'=='", "'}'", "'>='", "'!'", "LABEL", 
		"COMMENT", "TYPE", "'if'", "'elseif'", "'else'", "BOOLEAN", "IDENTIFIER", 
		"STRING", "DEC", "INT", "WS"
	};
	public static final String[] ruleNames = {
		"T__18", "T__17", "T__16", "T__15", "T__14", "T__13", "T__12", "T__11", 
		"T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", 
		"T__1", "T__0", "LABEL", "COMMENT", "TYPE", "IF", "ELSEIF", "ELSE", "BOOLEAN", 
		"IDENTIFIER", "STRING", "DEC", "INT", "WS"
	};


	public QL4Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "QL4.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2!\u00f1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3"+
		"\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\7\26t\n\26\f\26\16\26w\13\26\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00a2\n\27\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00bc\n\33\3\34\3\34\7\34\u00c0\n"+
		"\34\f\34\16\34\u00c3\13\34\3\35\3\35\7\35\u00c7\n\35\f\35\16\35\u00ca"+
		"\13\35\3\35\3\35\3\36\5\36\u00cf\n\36\3\36\7\36\u00d2\n\36\f\36\16\36"+
		"\u00d5\13\36\3\36\3\36\7\36\u00d9\n\36\f\36\16\36\u00dc\13\36\3\37\5\37"+
		"\u00df\n\37\3\37\3\37\7\37\u00e3\n\37\f\37\16\37\u00e6\13\37\3\37\5\37"+
		"\u00e9\n\37\3 \6 \u00ec\n \r \16 \u00ed\3 \3 \3u\2!\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!\3\2\5\4\2C\\c"+
		"|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\u0100\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\3A\3\2\2\2\5C\3\2\2\2\7E\3\2\2\2\tG\3\2\2\2\13I\3\2\2\2\rK\3\2\2\2\17"+
		"M\3\2\2\2\21O\3\2\2\2\23R\3\2\2\2\25T\3\2\2\2\27W\3\2\2\2\31Z\3\2\2\2"+
		"\33]\3\2\2\2\35_\3\2\2\2\37a\3\2\2\2!c\3\2\2\2#f\3\2\2\2%h\3\2\2\2\'k"+
		"\3\2\2\2)m\3\2\2\2+o\3\2\2\2-\u00a1\3\2\2\2/\u00a3\3\2\2\2\61\u00a6\3"+
		"\2\2\2\63\u00ad\3\2\2\2\65\u00bb\3\2\2\2\67\u00bd\3\2\2\29\u00c4\3\2\2"+
		"\2;\u00ce\3\2\2\2=\u00e8\3\2\2\2?\u00eb\3\2\2\2AB\7+\2\2B\4\3\2\2\2CD"+
		"\7-\2\2D\6\3\2\2\2EF\7/\2\2F\b\3\2\2\2GH\7,\2\2H\n\3\2\2\2IJ\7*\2\2J\f"+
		"\3\2\2\2KL\7<\2\2L\16\3\2\2\2MN\7>\2\2N\20\3\2\2\2OP\7#\2\2PQ\7?\2\2Q"+
		"\22\3\2\2\2RS\7=\2\2S\24\3\2\2\2TU\7>\2\2UV\7?\2\2V\26\3\2\2\2WX\7(\2"+
		"\2XY\7(\2\2Y\30\3\2\2\2Z[\7~\2\2[\\\7~\2\2\\\32\3\2\2\2]^\7}\2\2^\34\3"+
		"\2\2\2_`\7@\2\2`\36\3\2\2\2ab\7\61\2\2b \3\2\2\2cd\7?\2\2de\7?\2\2e\""+
		"\3\2\2\2fg\7\177\2\2g$\3\2\2\2hi\7@\2\2ij\7?\2\2j&\3\2\2\2kl\7#\2\2l("+
		"\3\2\2\2mn\59\35\2n*\3\2\2\2op\7\61\2\2pq\7\61\2\2qu\3\2\2\2rt\13\2\2"+
		"\2sr\3\2\2\2tw\3\2\2\2uv\3\2\2\2us\3\2\2\2vx\3\2\2\2wu\3\2\2\2xy\b\26"+
		"\2\2y,\3\2\2\2z{\7d\2\2{|\7q\2\2|}\7q\2\2}~\7n\2\2~\177\7g\2\2\177\u0080"+
		"\7c\2\2\u0080\u00a2\7p\2\2\u0081\u0082\7u\2\2\u0082\u0083\7v\2\2\u0083"+
		"\u0084\7t\2\2\u0084\u0085\7k\2\2\u0085\u0086\7p\2\2\u0086\u00a2\7i\2\2"+
		"\u0087\u0088\7k\2\2\u0088\u0089\7p\2\2\u0089\u008a\7v\2\2\u008a\u008b"+
		"\7g\2\2\u008b\u008c\7i\2\2\u008c\u008d\7g\2\2\u008d\u00a2\7t\2\2\u008e"+
		"\u008f\7f\2\2\u008f\u0090\7c\2\2\u0090\u0091\7v\2\2\u0091\u00a2\7g\2\2"+
		"\u0092\u0093\7f\2\2\u0093\u0094\7g\2\2\u0094\u0095\7e\2\2\u0095\u0096"+
		"\7k\2\2\u0096\u0097\7o\2\2\u0097\u0098\7c\2\2\u0098\u00a2\7n\2\2\u0099"+
		"\u009a\7e\2\2\u009a\u009b\7w\2\2\u009b\u009c\7t\2\2\u009c\u009d\7t\2\2"+
		"\u009d\u009e\7g\2\2\u009e\u009f\7p\2\2\u009f\u00a0\7e\2\2\u00a0\u00a2"+
		"\7{\2\2\u00a1z\3\2\2\2\u00a1\u0081\3\2\2\2\u00a1\u0087\3\2\2\2\u00a1\u008e"+
		"\3\2\2\2\u00a1\u0092\3\2\2\2\u00a1\u0099\3\2\2\2\u00a2.\3\2\2\2\u00a3"+
		"\u00a4\7k\2\2\u00a4\u00a5\7h\2\2\u00a5\60\3\2\2\2\u00a6\u00a7\7g\2\2\u00a7"+
		"\u00a8\7n\2\2\u00a8\u00a9\7u\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7k\2\2"+
		"\u00ab\u00ac\7h\2\2\u00ac\62\3\2\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af\7"+
		"n\2\2\u00af\u00b0\7u\2\2\u00b0\u00b1\7g\2\2\u00b1\64\3\2\2\2\u00b2\u00b3"+
		"\7v\2\2\u00b3\u00b4\7t\2\2\u00b4\u00b5\7w\2\2\u00b5\u00bc\7g\2\2\u00b6"+
		"\u00b7\7h\2\2\u00b7\u00b8\7c\2\2\u00b8\u00b9\7n\2\2\u00b9\u00ba\7u\2\2"+
		"\u00ba\u00bc\7g\2\2\u00bb\u00b2\3\2\2\2\u00bb\u00b6\3\2\2\2\u00bc\66\3"+
		"\2\2\2\u00bd\u00c1\t\2\2\2\u00be\u00c0\t\3\2\2\u00bf\u00be\3\2\2\2\u00c0"+
		"\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c28\3\2\2\2"+
		"\u00c3\u00c1\3\2\2\2\u00c4\u00c8\7$\2\2\u00c5\u00c7\4\"\u0080\2\u00c6"+
		"\u00c5\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2"+
		"\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc\7$\2\2\u00cc"+
		":\3\2\2\2\u00cd\u00cf\7/\2\2\u00ce\u00cd\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\u00d3\3\2\2\2\u00d0\u00d2\4\62;\2\u00d1\u00d0\3\2\2\2\u00d2\u00d5\3\2"+
		"\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5"+
		"\u00d3\3\2\2\2\u00d6\u00da\7\60\2\2\u00d7\u00d9\4\62;\2\u00d8\u00d7\3"+
		"\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"<\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00df\7/\2\2\u00de\u00dd\3\2\2\2\u00de"+
		"\u00df\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e4\4\63;\2\u00e1\u00e3\4\62"+
		";\2\u00e2\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4"+
		"\u00e5\3\2\2\2\u00e5\u00e9\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e9\7\62"+
		"\2\2\u00e8\u00de\3\2\2\2\u00e8\u00e7\3\2\2\2\u00e9>\3\2\2\2\u00ea\u00ec"+
		"\t\4\2\2\u00eb\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed"+
		"\u00ee\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\b \2\2\u00f0@\3\2\2\2\17"+
		"\2u\u00a1\u00bb\u00c1\u00c8\u00ce\u00d3\u00da\u00de\u00e4\u00e8\u00ed"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}