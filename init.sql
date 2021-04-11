
CREATE TABLE IF NOT EXISTS tale (
    id serial PRIMARY KEY,
    title text UNIQUE NOT NULL,
    description text NOT NULL
);

CREATE TABLE IF NOT EXISTS section (
    id serial PRIMARY KEY,
    section_number INTEGER NOT NULL,
    title text,
    text text,
    tale_id INTEGER REFERENCES tale(id)
);

INSERT INTO tale (title, description) VALUES ('Legendary Kingdoms: The Valley of Bones', 'Welcome to Legendary Kingdoms, a fantasy adventure gamebook where you take a party of adventurers into a dangerous and adventure-filled land.
Early in your career you will simply attempt to survive in a world of peril, but as you become more famous and powerful your actions will determine the fates of empires.');

INSERT INTO section (section_number, title, text, tale_id) VALUES (1, 'Carts', 'You stir into consciousness. Heat and blazing sunlight...
the slow rumble of a wagon... heavy chains upon your limbs. You groan, your mouth dry, your stomach empty.
As your eyes focus you can see your companions, fellow survivors of the brutal pirate attack, crushed together
with you upon the floor of a rolling wagon. You remember little since then, except vowing to your new-found friends that you would stick together, come what may.
You are relieved to see that they are still alive, but where are you?
Gazing through the bars of the wagon, your eyes focus on a blazing yellow-grey desert. To your left, filling the sky, are the Stonewalls – a massive and impenetrable mountain range that divides the barbarian kingdoms of the south from the antique and mysterious lands of Drakehallow. But which side of the range are you?
The answer becomes immediately apparent as you look beyond the smelly dragonyaks which are ponderously hauling your cage. A vast, crumbling city of minarets and run-down adobe buildings fills your view. The sting
in the air and on your lips tells you all you need to know. This is Saltdad, cruel throne of the tyrant Iron King, one of half a dozen tin-pot dictators in the barbaric Valley of Bones. You are far from civilised lands here...
Thin-faced slavers with spears rattle the sides of your cage, barking at you to get down. You slump on your hindquarters. For the moment there is nothing you can do with you and your companions in chains. You swear you will regain your freedom and start your lives anew. But first, you must survive the horrors of slavery.
Turn to 631.', 1);

INSERT INTO section (section_number, title, text, tale_id) VALUES (631, 'Sold', 'The slavers have sold you to the dreaded Saltdad Arena,
a grim place where the poor and criminals alike fight to the death for the savage entertainment of the crowd.
If you have the code A1, turn to 592.
If you have the code C17, turn to 582.
If not, read on.
If this is the first time you have been sold to
Saltdad Arena, turn to 271.
If you have fought in the arena before, turn to 582.', 1);
INSERT INTO section (section_number, title, text, tale_id) VALUES (271, 'Arena', 'The Saltdad Arena is the second largest complex in the
city, with only the ancient palace looming larger. Its
dungeons go deep into the earth, where prisoners, slaves
and monstrous animals are kept in large vaults, with only
the feeblest light pouring through barred arches set high
in the ceilings.
Your quarters are a large and ancient hall, whose
walls bear the sigils and faded murals of a more civilised
age. Within this chamber are crammed nearly a hundred
hungry captives, sleeping rough upon the gravel floor and
relieving themselves in stinking buckets stacked in a far
corner. You ask about feeding arrangements from one of
your fellow prisoners, who give you hollow looks. “You’ll
know it when it happens,” he warns.
Suddenly a hatch at the top of the hall is swung
open, and the barely-cooked carcass of a mountain goat
is dropped carelessly into the middle of the hall. There
is a great crush as the prisoners surge as one to tear off
strips of flesh from the animal. A group of strong men
from Lhasbreath, slaves like you, batter the crowd away
with threats, claiming first rights over the animal. You
are starving.
Challenge the men to first rights over the meat (turn
to 212)?
Attempt to side with the men, to ensure you get
something (turn to 282)?
Wait your turn to get something to eat (turn to 118)?', 1);
