from lxml import etree
import urllib.request

url = "https://www.coursera.org/account/accomplishments/verify/MTSHZTPD7MRY"

response = urllib.request.urlopen(url)
htmlparser = etree.HTMLParser()
tree = etree.parse(response, htmlparser)
req = urllib.request.urlopen(url).read()
print(tree.xpath("//p/*/text()")[0])