#!/bin/bash

echo -e "rock, scissors, paper"

while true
do
echo "enter your figure (paper, scissors, rock) or exit"
read figure

rand_figure=$((RANDOM % 3))

choose=$((RANDOM % 100))

if [[ "$choose" -gt "56" ]]; then 
# 0 - rock, 1 - scissors, 2 - paper

if [[ "$figure" = "rock" ]] ; then 
	if [[ "$rand_figure" = "2"  ]] ; then
		echo -e "computer figure is paper \nyou lose"

	elif [[ "$rand_figure" = "1" ]] ; then 
		echo -e "computer figure is scissors \nyou win"

	else
		echo -e "computer figure is rock \ndraw"
	fi

elif [[ "$figure" = "scissors" ]] ; then
	if [[ "$rand_figure" = "0" ]] ; then
		echo -e "computer figure is rock \nyou lose"

	elif [[ "$rand_figure" = "1" ]] ; then
		echo -e "computer figure is scissors \ndraw"

	else
		echo -e "computer figure is paper \nyou win"
	fi

elif [[ "$figure" = "paper" ]] ; then
	if [[ "$rand_figure" = "1" ]] ; then
		echo -e "computer figure is scissors \nyou lose"

	elif [[ "$rand_figure" = "0" ]] ; then
		echo -e "computer figure is rock \nyou win"

	else
		echo -e "computer figure is paper \ndraw"
	fi

elif [[ "$figure" = "exit" ]] ; then
	exit

else 
	echo incorrect command
fi


else
	if [[ "$figure" = "rock" ]] ; then 
		echo -e "computer figure is paper \nyou lose"

	elif [[ "$figure" = "paper" ]]  ; then
		echo -e "computer figure is scissors \nyou lose"

	elif [[ "$figure" = "scissors" ]] ; then
		echo -e "computer figure is rock \nyou lose"
	elif
		[[ "$figure" = "exit" ]] ; then
	exit
	else 
		echo incorrect command
	fi
fi
done 