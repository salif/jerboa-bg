package com.jerboa.util.markwon

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class ScriptRewriteSupportPluginTest {
    @Test
    @Parameters(
        method = "successCases",
    )
    fun `should rewrite lemmy script to markwon script`(
        input: String,
        expected: String,
    ) {
        val result = ScriptRewriteSupportPlugin.rewriteLemmyScriptToMarkwonScript(input)
        Assert.assertEquals(expected, result)
    }

    fun successCases() =
        listOf(
            listOf("^2^", "<sup>2</sup>"),
            listOf("~2~", "<sub>2</sub>"),
            listOf("~2~ ~2~", "<sub>2</sub> <sub>2</sub>"),
            listOf("^2^ ^2^", "<sup>2</sup> <sup>2</sup>"),
            listOf("^^", "^^"),
            listOf("^\n^", "^\n^"),
            listOf("~2~~2~", "<sub>2</sub><sub>2</sub>"),
            listOf("~2~\n~2~", "<sub>2</sub>\n<sub>2</sub>"),
            listOf("~2~\n~2~", "<sub>2</sub>\n<sub>2</sub>"),
            listOf("~ blah blah", "~ blah blah"),
            listOf("", ""),
        )
}
