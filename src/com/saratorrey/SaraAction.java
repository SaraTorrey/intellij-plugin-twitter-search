package com.saratorrey;

import com.intellij.ide.BrowserUtil;
import com.intellij.lang.Language;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;

import org.jetbrains.annotations.NotNull;

public class SaraAction extends AnAction {

    @Override public void actionPerformed( @NotNull AnActionEvent e ) {

        // some of the following text selection code was borrowed from the tutorial: https://www.baeldung.com/intellij-new-custom-plugin

        PsiFile file = e.getData( CommonDataKeys.PSI_FILE);
        Language lang = e.getData( CommonDataKeys.PSI_FILE).getLanguage();
        String languageTag = "+[" + lang.getDisplayName().toLowerCase() + "]";

        Editor editor = e.getRequiredData( CommonDataKeys.EDITOR);
        CaretModel caretModel = editor.getCaretModel();
        String selectedText = caretModel.getCurrentCaret().getSelectedText();

        String searchTerm = selectedText.replace(' ', '+') + languageTag;

        BrowserUtil.browse( "https://twitter.com/search?q=" + searchTerm + "&src=typed_queryk");
    }
}