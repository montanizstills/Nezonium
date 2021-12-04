package com.vertexinc.returns.test.cloudui.util.resources.page;

import com.vertexinc.returns.test.cloudui.util.interfaces.PageInterface;
import org.openqa.selenium.By;

public interface CloudHomePageInterface extends PageInterface {
    By dashboardButton = By.cssSelector("a[href='/Admin/AdminDash']");
}
