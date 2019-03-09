from Markov import Scrape_Markov
from Markov import Markov_Gen

# https://github.com/jsvine/markovify
stop = False
handles = []
while not stop:
    handle = input("input twitter handle: ")
    handles.append(handle)
    yn = input("any more handles? (y/n) ")
    stop = (yn == "n")

handles_name = ""
for handle in handles:
    handles_name = handles_name+str(handle)+"_"
handles_name = handles_name+"_tweets"

all_tweets = []
for handle in handles:
    print("downloading tweets from " + handle)
    Scrape_Markov.get_all_tweets(handle)
    all_tweets.extend(Scrape_Markov.return_tweets())

with open(handles_name + '.txt', 'w+') as f:
    for tweet in all_tweets:
        f.write(tweet + "\n")

Markov_Gen.gen_markov(all_tweets, handles_name)

