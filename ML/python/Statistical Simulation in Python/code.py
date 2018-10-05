# Statistical Simulation in Python
# ch-1 Basics of randomness & simulation
# Poisson random variable
# Initialize seed and parameters
np.random.seed(123) 
lam, size_1, size_2 = 5, 3, 1000  

# Draw samples & calculate absolute difference between lambda and sample mean
samples_1 = np.random.poisson(lam, size_1)
samples_2 = np.random.poisson(lam, size_2)
answer_1 = abs(np.mean(samples_1)-lam)
answer_2 = abs(np.mean(samples_2)-lam) 

print("|Lambda - sample mean| with {} samples is {} and with {} samples is {}. ".format(size_1, answer_1, size_2, answer_2))

# Shuffling a deck of cards
# Shuffle the deck
np.random.shuffle(deck_of_cards)

# Print out the top three cards
card_choices_after_shuffle = deck_of_cards[0:3]
print(card_choices_after_shuffle)

# Throwing a fair die
# first two steps of running a simulation - defining a random variable and assigning probabilities.
# Define die outcomes and probabilities
die, probabilities, throws = [1,2,3,4,5,6], [1/6,1/6,1/6,1/6,1/6,1/6], 1

# Use np.random.choice to throw the die once and record the outcome
outcome = np.random.choice(die, size=1, p=probabilities)
print("Outcome of the throw: {}".format(outcome[0]))

# Throwing two fair dice
# Initialize number of dice, simulate & record outcome
die, probabilities, num_dice = [1,2,3,4,5,6], [1/6, 1/6, 1/6, 1/6, 1/6, 1/6], 2
outcomes = np.random.choice(die, size=2, p=probabilities) 

# Win if the two dice show the same number
if outcomes[0] == outcomes[1]: 
    answer = 'win' 
else:
    answer = 'lose'

print("The dice show {} and {}. You {}!".format(outcomes[0], outcomes[1], answer))