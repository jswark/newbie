import requests
from bs4 import BeautifulSoup

track_name = "Slow dancing in the dark"  # input("Enter the name of the track ")
author = "Joji"  # input("Enter the author name ")

if len(track_name.split()) > 1:
    track_name = track_name.replace(' ', '-').lower()
if len(author.split()) > 1:
    author = author.replace(' ', '-')

# https://genius.com/Joji-slow-dancing-in-the-dark-lyrics
link = f'https://genius.com/{author}-{track_name}-lyrics'
api = requests.get(link)

if api.status_code == 200:

    result = BeautifulSoup(api.text, 'html.parser')
    while True:
        try:
            result = result.find("div", class_="lyrics").text.split('\n')
            break

        except:
            api = requests.get(link)
            result = BeautifulSoup(api.text, 'html.parser')

    file = open(f'{author}-{track_name}.txt', 'w')

    for i in result:
        file.write(i + '\n')
        print(i)
    file.close()
else:
    print("Sorry... Error number is ", api.status_code)
