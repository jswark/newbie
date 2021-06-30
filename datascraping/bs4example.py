import requests as re
from bs4 import BeautifulSoup

response = re.get('https://www.coursera.org/account/accomplishments/verify/MTSHZTPD7MRY')
#print(response.text)
soup = BeautifulSoup(response.text, 'html.parser')
print(soup.select("p")[3].text)

