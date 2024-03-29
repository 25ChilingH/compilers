package scanner;
// DO NOT EDIT
// Generated by JFlex 1.9.1 http://jflex.de/
// source: /Users/chilinghan/Documents/Github/compilers/JFlexScanner.flex

/**
* This file defines a simple lexer for the compilers course 2017-2018
* Comment this file
*/

import java.io.*;


@SuppressWarnings("fallthrough")
public class JFlexScanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\25\u0100\1\u0200\11\u0100\1\u0300\17\u0100\1\u0400\247\u0100"+
    "\10\u0500\u1020\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\2\3\1\1\22\0\1\1\1\0"+
    "\1\4\11\0\1\5\1\6\1\7\1\10\12\11\1\12"+
    "\6\0\23\13\1\14\5\13\1\15\4\0\1\16\1\0"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\3\24\1\30\1\24\1\31\1\32\1\24\1\33"+
    "\1\34\1\35\1\36\5\24\12\0\1\3\32\0\1\1"+
    "\u01df\0\1\1\177\0\13\1\35\0\2\3\5\0\1\1"+
    "\57\0\1\1\240\0\1\1\377\0\u0100\37";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1536];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\3\1\4\0\1\2\15\0\1\3\125\0\1\4"+
    "\2\0\1\5\33\0\1\6";

  private static int [] zzUnpackAction() {
    int [] result = new int[140];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\40\0\100\0\140\0\200\0\240\0\300\0\340"+
    "\0\40\0\140\0\u0100\0\u0120\0\u0140\0\u0160\0\u0180\0\u01a0"+
    "\0\u01c0\0\u01e0\0\u0200\0\u0220\0\u0240\0\u0260\0\40\0\u0280"+
    "\0\u02a0\0\u02c0\0\u02e0\0\u0300\0\u0320\0\u0340\0\u0360\0\u0380"+
    "\0\u03a0\0\u03c0\0\u03e0\0\u0400\0\u0420\0\u0440\0\u0460\0\u0480"+
    "\0\u04a0\0\u04c0\0\u04e0\0\u0500\0\u0520\0\u0540\0\u0560\0\u0580"+
    "\0\u05a0\0\u05c0\0\u05e0\0\u0600\0\u0620\0\u0640\0\u0660\0\u0680"+
    "\0\u06a0\0\u06c0\0\u06e0\0\u0700\0\u0720\0\u0740\0\u0760\0\u0780"+
    "\0\u07a0\0\u07c0\0\u07e0\0\u0800\0\u0820\0\u0840\0\u0860\0\u0880"+
    "\0\u08a0\0\u08c0\0\u08e0\0\u0900\0\u0920\0\u0940\0\u0960\0\u0980"+
    "\0\u09a0\0\u09c0\0\u09e0\0\u0a00\0\u0a20\0\u0a40\0\u0a60\0\u0a80"+
    "\0\u0aa0\0\u0ac0\0\u0ae0\0\u0b00\0\u0b20\0\u0b40\0\u0b60\0\u0b80"+
    "\0\u0ba0\0\u0bc0\0\u0be0\0\u0c00\0\u0c20\0\u0c40\0\u0c60\0\u0c80"+
    "\0\u0ca0\0\u0cc0\0\u0ce0\0\u0d00\0\40\0\u0d20\0\u0d40\0\40"+
    "\0\u0d60\0\u0d80\0\u0da0\0\u0dc0\0\u0de0\0\u0e00\0\u0e20\0\u0e40"+
    "\0\u0e60\0\u0e80\0\u0ea0\0\u0ec0\0\u0ee0\0\u0f00\0\u0f20\0\u0f40"+
    "\0\u0f60\0\u0f80\0\u0fa0\0\u0fc0\0\u0fe0\0\u1000\0\u1020\0\u1040"+
    "\0\u1060\0\u1080\0\u10a0\0\40";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[140];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\3\2\1\0\1\3\4\2\1\4\25\2\52\0\1\5"+
    "\1\0\3\5\1\6\2\5\1\7\4\5\1\10\10\5"+
    "\3\0\1\11\6\0\1\12\35\0\1\13\1\0\1\14"+
    "\1\0\3\14\1\6\20\14\10\0\1\13\1\0\1\6"+
    "\1\0\24\6\10\0\1\13\1\0\1\14\1\0\3\14"+
    "\1\6\14\14\1\15\3\14\10\0\1\13\1\0\1\14"+
    "\1\0\3\14\1\6\16\14\1\16\1\14\20\0\20\17"+
    "\10\0\1\13\1\0\1\20\1\0\3\20\1\6\20\20"+
    "\10\0\1\13\1\0\1\20\1\0\3\20\1\6\4\20"+
    "\1\21\13\20\10\0\1\13\1\0\1\20\1\0\3\20"+
    "\1\6\16\20\1\22\1\20\5\0\1\23\12\0\20\17"+
    "\10\0\1\13\1\0\1\24\1\0\3\24\1\6\20\24"+
    "\10\0\1\13\1\0\1\24\1\0\3\24\1\6\1\25"+
    "\17\24\10\0\1\13\1\0\1\24\1\0\3\24\1\6"+
    "\13\24\1\26\4\24\6\0\1\27\41\0\1\13\1\0"+
    "\1\30\1\0\3\30\1\6\20\30\10\0\1\13\1\0"+
    "\1\30\1\0\3\30\1\6\16\30\1\31\1\30\10\0"+
    "\1\13\1\0\1\30\1\32\3\30\1\6\15\30\1\33"+
    "\2\30\10\0\1\13\1\0\1\34\1\0\3\34\1\6"+
    "\20\34\10\0\1\13\1\0\1\34\1\0\3\34\1\6"+
    "\4\34\1\35\13\34\11\0\1\36\36\0\1\13\1\0"+
    "\1\34\1\32\3\34\1\6\20\34\10\0\1\13\1\0"+
    "\1\37\1\0\3\37\1\6\20\37\10\0\1\13\1\0"+
    "\1\37\1\0\3\37\1\6\3\37\1\40\14\37\11\0"+
    "\1\41\36\0\1\13\1\0\1\42\1\0\3\42\1\6"+
    "\20\42\10\0\1\13\1\0\1\42\1\0\3\42\1\43"+
    "\20\42\20\0\1\44\27\0\1\13\1\0\1\45\1\0"+
    "\3\45\1\6\20\45\10\0\1\13\1\0\1\6\1\0"+
    "\4\6\1\46\17\6\33\0\1\47\14\0\1\13\1\0"+
    "\1\50\1\0\3\50\1\6\20\50\10\0\1\13\1\0"+
    "\1\6\1\0\22\6\1\51\1\6\30\0\1\52\17\0"+
    "\1\13\1\0\1\53\1\0\3\53\1\6\20\53\5\0"+
    "\1\54\2\0\1\13\1\0\1\6\1\0\24\6\10\0"+
    "\1\55\37\0\1\13\1\0\1\56\1\0\3\56\1\6"+
    "\20\56\13\0\1\57\52\0\1\60\21\0\1\13\1\0"+
    "\1\61\1\0\3\61\1\6\20\61\2\0\3\57\1\62"+
    "\62\0\1\63\17\0\1\13\1\0\1\64\1\0\3\64"+
    "\1\6\20\64\12\0\1\65\63\0\1\66\11\0\1\13"+
    "\1\0\1\67\1\0\3\67\1\6\20\67\12\0\1\70"+
    "\54\0\1\71\20\0\1\13\1\0\1\72\1\0\3\72"+
    "\1\6\20\72\12\0\1\73\64\0\1\74\10\0\1\13"+
    "\1\0\1\75\1\0\3\75\1\6\20\75\12\0\1\76"+
    "\46\0\1\77\26\0\1\13\1\0\1\100\1\0\3\100"+
    "\1\6\20\100\7\0\1\101\40\0\1\102\37\0\1\13"+
    "\1\0\1\103\1\0\3\103\1\6\20\103\12\0\1\104"+
    "\47\0\1\105\25\0\1\13\1\0\1\106\1\0\3\106"+
    "\1\6\20\106\12\0\1\107\57\0\1\110\15\0\1\13"+
    "\1\0\1\111\1\0\3\111\1\6\20\111\7\0\1\112"+
    "\61\0\1\113\16\0\1\13\1\0\1\114\1\0\3\114"+
    "\1\6\20\114\12\0\1\115\36\0\1\116\36\0\1\13"+
    "\1\0\1\117\1\0\3\117\1\6\20\117\12\0\1\120"+
    "\53\0\1\121\21\0\1\13\1\0\1\122\1\0\3\122"+
    "\1\6\20\122\15\0\1\123\52\0\1\124\17\0\1\13"+
    "\1\0\1\125\1\0\3\125\1\6\20\125\12\0\1\126"+
    "\62\0\1\127\12\0\1\13\1\0\1\130\1\0\3\130"+
    "\1\6\20\130\12\0\1\131\63\0\1\132\11\0\1\13"+
    "\1\0\1\133\1\0\3\133\1\6\20\133\13\0\1\134"+
    "\61\0\1\135\12\0\1\13\1\0\1\136\1\0\3\136"+
    "\1\6\20\136\12\0\1\137\36\0\1\140\36\0\1\13"+
    "\1\0\1\141\1\0\3\141\1\6\20\141\12\0\1\142"+
    "\37\0\1\143\1\0\3\143\1\0\20\143\10\0\1\13"+
    "\1\0\1\144\1\0\3\144\1\6\20\144\13\0\1\145"+
    "\36\0\1\146\1\0\3\146\1\0\20\146\10\0\1\13"+
    "\1\0\1\147\1\0\3\147\1\6\20\147\12\0\1\150"+
    "\37\0\1\151\1\0\3\151\1\0\20\151\10\0\1\13"+
    "\1\0\1\152\1\0\3\152\1\6\20\152\12\0\1\153"+
    "\37\0\1\154\1\0\3\154\1\0\20\154\5\0\1\155"+
    "\2\0\1\13\1\0\1\6\1\0\24\6\16\0\1\156"+
    "\33\0\1\157\1\0\3\157\1\0\20\157\5\0\1\160"+
    "\44\0\1\161\1\0\3\161\1\0\20\161\12\0\1\162"+
    "\1\0\3\162\1\0\20\162\12\0\1\163\1\0\3\163"+
    "\1\0\20\163\12\0\1\164\1\0\3\164\1\0\20\164"+
    "\12\0\1\165\1\0\3\165\1\0\20\165\12\0\1\166"+
    "\1\0\3\166\1\0\20\166\12\0\1\167\1\0\3\167"+
    "\1\0\20\167\12\0\1\170\1\0\3\170\1\0\20\170"+
    "\12\0\1\171\1\0\3\171\1\0\20\171\12\0\1\172"+
    "\1\0\3\172\1\0\20\172\12\0\1\173\1\0\3\173"+
    "\1\0\20\173\12\0\1\174\1\0\3\174\1\0\20\174"+
    "\12\0\1\175\1\0\3\175\1\0\20\175\12\0\1\176"+
    "\1\0\3\176\1\0\20\176\12\0\1\177\1\0\3\177"+
    "\1\0\20\177\12\0\1\200\1\0\3\200\1\0\20\200"+
    "\12\0\1\201\1\0\3\201\1\0\20\201\12\0\1\202"+
    "\1\0\3\202\1\0\20\202\12\0\1\203\1\0\3\203"+
    "\1\0\20\203\12\0\1\204\1\0\3\204\1\0\20\204"+
    "\12\0\1\205\1\0\3\205\1\0\20\205\12\0\1\206"+
    "\1\0\3\206\1\0\20\206\12\0\1\207\1\0\3\207"+
    "\1\0\20\207\12\0\1\210\1\0\3\210\1\0\20\210"+
    "\12\0\1\211\1\0\3\211\1\0\20\211\12\0\1\212"+
    "\1\0\3\212\1\0\20\212\12\0\1\213\1\0\3\213"+
    "\1\0\20\213\5\0\1\214\33\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[4288];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\2\1\4\0\1\11\15\0\1\11\125\0"+
    "\1\11\2\0\1\11\33\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[140];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public JFlexScanner(java.io.Reader in) {
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate && zzCanGrow()) {
      /* if not, and it can grow: blow it up */
      char newBuffer[] = new char[Math.min(zzBuffer.length * 2, zzMaxBufferLen())];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      if (requested == 0) {
        throw new java.io.EOFException("Scan buffer limit reached ["+zzBuffer.length+"]");
      }
      else {
        throw new java.io.IOException(
            "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
      }
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    int initBufferSize = Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen());
    if (zzBuffer.length > initBufferSize) {
      zzBuffer = new char[initBufferSize];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  public String nextToken() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
          { return "END";
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { 
            }
          // fall through
          case 7: break;
          case 2:
            { return "size: " + yytext().stripTrailing();
            }
          // fall through
          case 8: break;
          case 3:
            { return "file: " + yytext().replaceAll(",", "");
            }
          // fall through
          case 9: break;
          case 4:
            { return "id: " + yytext();
            }
          // fall through
          case 10: break;
          case 5:
            { String match = yytext();
                String created = match.replaceAll("^.*\"([0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}Z)\".*$", "$1");
                return "created at: " + created;
            }
          // fall through
          case 11: break;
          case 6:
            { return "url: " + yytext();
            }
          // fall through
          case 12: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
