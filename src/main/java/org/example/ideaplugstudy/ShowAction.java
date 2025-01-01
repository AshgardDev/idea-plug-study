package org.example.ideaplugstudy;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;

/**
 * @Description:
 * @Author: hbj
 * @Email: huangbinjie2024@gmail.com
 * @Date:2025/1/1 23:00
 */
public class ShowAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        System.out.println("e = " + e);
        Messages.showInfoMessage("hello world", "idea plugin show test");
    }
}
