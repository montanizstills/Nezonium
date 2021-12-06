package com.vertexinc.returns.test.cloudui.util.resources.page;

import com.vertexinc.returns.test.cloudui.util.interfaces.PageInterface;
import org.openqa.selenium.By;

public interface CloudHomePageInterface extends PageInterface {
    By dashboardButton = By.cssSelector("a[href='/Admin/AdminDash']");
    By ratesJurisdictionButton = By.cssSelector("a[href='/Admin/RateLookup']");
    By ospLogsSearchButton = By.cssSelector("a[href='/Admin/OspLogsSearch']");
    By queueServiceButton = By.cssSelector("a[href='/Admin/QueueService/QueueServiceSummaryDetail']");
    By ctcImpactButton = By.cssSelector("a[href='/Admin/AdminDash#']");
    By ctcImpactTaxAreaTransactionsButton = By.cssSelector("a[href='/Admin/CtcImpact/TaxAreaTransactions']");
    By ctcImpactTaxabilityCategoriesButton = By.cssSelector("a[href='/Admin/CtcImpact/TaxabilityCategories']");
    By ctcImpactReturnsButton = By.cssSelector("a[href='/Admin/CtcImpact/Returns']");
    By ctcImpactStateRegistrationsButton = By.cssSelector("a[href='/Admin/CtcImpact/StateRegistrations']");

    By logsButton = By.xpath("/html/body/div[1]/div/div[1]/div[1]/ul/li[6]/a");//Main has no redirect. Redirect Home. Brittle implementation.

    By logsTaxLinkLogsButton = By.cssSelector("a[href='/Admin/LogFile']");
    By logsECWLogsButton = By.cssSelector("a[href='/Admin/EcWizardLogs']");
    By logsBigCommerceLogs = By.cssSelector("a[href='/Admin/BigCommerceLogs']");
    By manageCustomersButton = By.cssSelector("a[href='/Admin/CustomerManagement']"); /*TODO - test clicking this endpoint/button*/
    By premiumCustomersButton = By.cssSelector("a[href='#']");//Main has no redirect. Redirect Home.
    By premiumCustomersPremiumCustomersButton = By.cssSelector("a[href='/Admin/Premium']");
    By premiumCustomersDownloadReturnsFilesButton = By.cssSelector("a[href='/Admin/Premium/DownloadReturnFiles']");
    By metricsButton = By.cssSelector("a[href='/Admin/Metrics']");
    By documentCenterButton = By.cssSelector("a[href='/Admin/DocumentCenter']");
    By inviteUsersButton = By.cssSelector("a[href='/Admin/Users/Invite']");
    By vertexUsersButton = By.cssSelector("a[href='/Admin/Users']");
    By vertexCloudVarsButton = By.cssSelector("a[href='/Admin/Clients/Vars']");
    By inlineHelpEditorButton = By.cssSelector("a[href='/Admin/InlineHelp']");
    By updateNotificationButton = By.cssSelector("a[href='/Admin/Notifier']");
    By manageOSeriesConfigButton = By.cssSelector("a[href='/Admin/ManageOSeries']");
    By manageReturnsConfigButtong = By.cssSelector("a[href='/Admin/ReturnFields']");
    By manageTaxCalendarButton = By.cssSelector("a[href='/Admin/TaxCalendar']");
    By errorMonitorButton = By.cssSelector("a[href='/Admin/ManageQueueWorkflow']");
    By systemConfigurationButton = By.cssSelector("a[href='/Admin/SystemConfiguration']");
    By OAuthCredentialManagementButton = By.cssSelector("a[href='/Admin/OAuthCredentials/Create']");
    By collapseButton = By.cssSelector("a[href='#']");//Main has no redirect. Redirect Home.
    By visitHelpCenterButton = By.cssSelector("a[href='/Admin/VisitHelpCenter']");
    By whatsNewButton = By.cssSelector("a[href='/Admin/VisitHelpCenter/WhatsNew']");
}
