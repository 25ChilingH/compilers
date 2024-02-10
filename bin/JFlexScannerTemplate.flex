package scanner;
/**
* This file defines a simple lexer for the compilers course 2017-2018
* Comment this file
*/
import java.io.*;


%%
/* lexical functions */
/* specify that the class will be called Scanner and the function to get the next
 * token is called nextToken.  
 */
%class Scanner
%unicode
%line
%public
%function nextToken
/*  return String objects - the actual lexemes */
/*  returns the String "END: at end of file */
%type String
%eofval{
return "END";
%eofval}
/* use switch statement to encode DFA */


/**
 * Pattern definitions
 */
idNoQuotes = [a-zA-Z0-9]{32}
whitespace = [ \t\n\r]

id = \"{idNoQuotes}\"
url = \"https?\:\/\/api\.github\.com\/gists\/{idNoQuotes}\"
size = [0-9]+\n
file = \"[a-zA-Z0-9]+\.[a-z]+\"

%%
/**
 * lexical rules
 */
{id} {return "id: " + yytext();}
{url} {return "url: " + yytext();}
{size} {return "size: " + yytext().stripTrailing();}
{file} {return "file: " + yytext();}
{whitespace} {}
. {}
