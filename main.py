# Hello cac ban nho
# Day la tool check hotmail & yahoo nhe!
from requests_html import HTMLSession

# Check Hotmail
HOTMAIL = "thaiduong345456@hotmail.com"
post_data = {
    "email": HOTMAIL
}
session = HTMLSession()
response = session.post("https://tools-trickfb.herokuapp.com/api/v1/check-mail", data=post_data)
print(response.text)

# Check yahoo
YAHOO = "thaiduong34545@yahoo.com"
session = HTMLSession()
response = session.get(f"https://mmo69.com/_check_live_email/api.php?email={YAHOO}")
print(response.text)
#................................................123456789 test
-----------------------------fjwaoiofjawf
dwadwaudwaudwuadu
