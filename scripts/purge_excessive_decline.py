import pathlib
from time import sleep

from selenium.webdriver.common.by import By

from scripts.extract import process_file
from src.common.utils.Driver import Driver, BrowserType
from src.common.utils.Utils import xpath_literal

# CREDS
USERNAME = "mstills@rpmdev.com"
PASSWORD = "gMvfj58Pt$uSYFq"

# SITES (URLS)
YARDI_ONE = "https://rpm55118.yardione.com/"
COMPLIANCE_DASHBOARD = "https://sitemanager.rentcafe.com/sitemanager/affordable/compliancedashboard.aspx"

# BUTTONS, FIELDS
RENT_CAFE_SITE_MANAGER = "/html/body/div[1]/div[2]/div[2]/main/div/div[2]/div/div/div/div/div[3]/div/a/div"
SEARCH_ALL_APPLICATIONS_BUTTON = "/html/body/div/div/div[2]/div[3]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[1]/div/div/div/a/div/span[2]/span[1]"
YARDI_ONE_USERNAME_FIELD = "/html/body/div/div/div[1]/div/div[2]/div/div/div[2]/form/fieldset/div[1]/input" #"/html/body/div/div/div[1]/div/div[2]/div[2]/div[2]/form/fieldset/div[1]/input"
YARDI_ONE_PASSWORD_FIELD = "/html/body/div/div/div[1]/div/div[2]/div/div/div[2]/form/fieldset/div[2]/input" #"/html/body/div/div/div[1]/div/div[2]/div[2]/div[2]/form/fieldset/div[2]/input"
YARDI_ONE_LOGIN_BUTTON = "/html/body/div/div/div[1]/div/div[2]/div/div/div[2]/form/fieldset/div[4]/button" #"/html/body/div/div/div[1]/div/div[2]/div[2]/div[2]/form/fieldset/div[4]/button"

HOUSEHOLD_PAGE_LASTNAME = "/html/body/div[1]/div/div[2]/div[3]/div[1]/div[2]/div/form/div[5]/div[1]/div[2]/div/input"
HOUSEHOLD_PAGE_FIRSTNAME = "/html/body/div[1]/div/div[2]/div[3]/div[1]/div[2]/div/form/div[5]/div[2]/div[2]/div/input"
HOUSEHOLD_PAGE_FIND_BUTTON = "/html/body/div[1]/div/div[2]/div[3]/div[1]/div[2]/div/form/div[5]/div[4]/button[1]"
HOUSEHOLD_PAGE_PAGINATE_DROPDOWN = "select[name*='ApplicantListGrid_length']"
HOUSEHOLD_PAGE_CLEAR_BUTTON = "#btnClear"
HOUSEHOLD_PAGE_MORE_BUTTON = "/html/body/div[1]/div/div[2]/div[3]/div[1]/div[1]/div[2]/div/ul/li[4]/div/button"
HOUSEHOLD_PAGE_REMOVE_FROM_WAITLIST_BUTTON = "/html/body/div[1]/div/div[2]/div[3]/div[1]/div[1]/div[2]/div/ul/li[4]/div/ul/li[3]/a"
HOUSEHOLD_PAGE_REMOVE_FROM_WAITLIST_TEXTAREA = "/html/body/div[4]/div[2]/div/form/div[2]/div/div/div/textarea"
HOUSEHOLD_PAGE_REMOVE_FROM_WAITLIST_SAVE_BUTTON = "/html/body/div[4]/div[2]/div/form/div[3]/button[1]"

DENIAL_REASON = "excessive declines > 3x"


def log_result(first_name, last_name, count, filepath):
    with open(filepath, "a", encoding="utf-8") as f:
        f.write(f"{first_name},{last_name},count: {count}\n")





def declined_status_xpath(last_name: str, first_name: str) -> str:
    """
    Build the 'Declined' row-selector XPath for a given applicant name,
    safely escaping apostrophes/quotes in either name part.
    """
    full_name = f"{last_name.strip()}, {first_name.strip()}"
    return (
        "//tr[td[@data-label='Status'][normalize-space(.)='Declined'] "
        f"and td[@data-label='Name'][normalize-space(.)={xpath_literal(full_name)}]]"
    )


if __name__ == "__main__":
    driver = Driver(BrowserType.EDGE, 20)
    driver.navigate(YARDI_ONE)
    driver.send_keys(By.XPATH, YARDI_ONE_USERNAME_FIELD, USERNAME)
    driver.send_keys(By.XPATH, YARDI_ONE_PASSWORD_FIELD, PASSWORD)
    driver.click(By.XPATH, YARDI_ONE_LOGIN_BUTTON)  # LOGIN
    sleep(30)
    driver.click(By.XPATH, RENT_CAFE_SITE_MANAGER)
    sleep(4)
    driver.get_driver().switch_to.window(
        driver.get_driver().window_handles[-1])  # can close window[0] after this line executes
    driver.click(By.XPATH, SEARCH_ALL_APPLICATIONS_BUTTON)

    for list in pathlib.Path(r"C:\Users\Mstills\Downloads\WaitListQueue").iterdir():
        property, unit_type = list.name.split("_")[:2]
        print(f"Starting purge on {property} {unit_type} list.")
        applicants = process_file(str(list))

        for applicant in applicants:
            driver.click(By.CSS_SELECTOR, HOUSEHOLD_PAGE_CLEAR_BUTTON)
            print(f"Processing {applicant}...")
            first_name, last_name = applicant.split(",")
            driver.send_keys(By.XPATH, HOUSEHOLD_PAGE_LASTNAME, last_name)
            driver.send_keys(By.XPATH, HOUSEHOLD_PAGE_FIRSTNAME, first_name)
            sleep(3)
            driver.click(By.XPATH, HOUSEHOLD_PAGE_FIND_BUTTON)
            sleep(6)
            driver.to_select(By.CSS_SELECTOR, HOUSEHOLD_PAGE_PAGINATE_DROPDOWN).select_by_value("100")
            sleep(10)

            STATUS_DECLINED_SELECTOR = declined_status_xpath(last_name, first_name)
            status_cells = driver.get_driver().find_elements(By.XPATH, STATUS_DECLINED_SELECTOR)
            declined_count = len(status_cells)
            if declined_count >= 3:
                print(f"Purging {last_name}, {first_name} from {list}")
                log_result(first_name, last_name, declined_count, f"excessive_declined_{property}_{unit_type}.txt")
            sleep(7)
    exit(0)


# if __name__ == "__main__":
#     driver = Driver(BrowserType.CHROME, 20)
#     driver.navigate(YARDI_ONE)
#     driver.send_keys(By.XPATH, YARDI_ONE_USERNAME_FIELD, USERNAME)
#     driver.send_keys(By.XPATH, YARDI_ONE_PASSWORD_FIELD, PASSWORD)
#     driver.click(By.XPATH, YARDI_ONE_LOGIN_BUTTON)  # LOGIN
#     sleep(30)
#     driver.click(By.XPATH, RENT_CAFE_SITE_MANAGER)
#     sleep(4)
#     driver.get_driver().switch_to.window(
#         driver.get_driver().window_handles[-1])  # can close window[0] after this line executes
#     driver.click(By.XPATH, SEARCH_ALL_APPLICATIONS_BUTTON)
#
#     for list in pathlib.Path(r"C:\Users\Mstills\Downloads\WaitListQueue").iterdir():
#         property, unit_type = list.name.split("_")[:2]
#         print(f"Starting purge on {property} {unit_type} list.")
#         applicants = process_file(str(list))
#
#         for applicant in applicants:
#             driver.click(By.CSS_SELECTOR, HOUSEHOLD_PAGE_CLEAR_BUTTON)
#             print(f"Processing {applicant}...")
#             first_name, last_name = applicant.split(",")
#             driver.send_keys(By.XPATH, HOUSEHOLD_PAGE_LASTNAME, last_name)
#             driver.send_keys(By.XPATH, HOUSEHOLD_PAGE_FIRSTNAME, first_name)
#             sleep(3)
#             driver.click(By.XPATH, HOUSEHOLD_PAGE_FIND_BUTTON)
#             sleep(6)
#             driver.to_select(By.CSS_SELECTOR, HOUSEHOLD_PAGE_PAGINATE_DROPDOWN).select_by_value("100")
#             sleep(10)
#             STATUS_NORMALS_DECLINED_SELECTOR = f"//tr[td[@data-label='Status'][normalize-space(.)='Declined'] and td[@data-label='Name'][normalize-space(.)='{last_name.strip()}, {first_name.strip()}']]"
#             status_cells = driver.get_driver().find_elements(By.XPATH, STATUS_NORMALS_DECLINED_SELECTOR)
#             declined_count = len(status_cells)
#             if declined_count >= 3:
#                 print(f"Purging {last_name}, {first_name} from {list}")
#                 log_result(first_name, last_name, declined_count, f"excessive_declined_{property}_{unit_type}.txt")
#             sleep(7)
#     exit(1)
