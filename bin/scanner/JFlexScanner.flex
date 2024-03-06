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
%class JFlexScanner
%unicode
%line
%public
%function nextToken
/*  return String objects - the actual lexemes */
/*  returns the String "END: at end of file */
%type String
%eofval{
return "END";
%eofval}

/**
 * Pattern definitions
 */

id              = \"[a-zA-Z0-9]{32}\"
identifier      = [a-zA-Z0-9]{32}
url             = \"https?\:\/\/api\.github\.com\/gists\/{identifier}\"
time            = \""created_at"\":\s*\"[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}Z\"
size		= [0-9]+\n
file		= \"[a-zA-Z0-9_]+\.[a-z]+\",
whitespace      = [ \t\n\r]

%%
/**
* lexical rules
*/

{id}            {return "id: " + yytext();}
{url}           {return "url: " + yytext();}
{time}          {String match = yytext();
                String created = match.replaceAll("^.*\"([0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}Z)\".*$", "$1");
                return "created at: " + created;}
{size}		{return "size: " + yytext().stripTrailing();}
{file}		{return "file: " + yytext().replaceAll(",", "");}
{whitespace}    {}
.               {}