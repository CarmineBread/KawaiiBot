package me.alexflipnote.kawaiibot.commands

import me.alexflipnote.kawaiibot.utils.Helpers
import me.devoxin.flight.Context
import me.devoxin.flight.annotations.Command
import me.devoxin.flight.arguments.Name
import me.devoxin.flight.models.Cog

class Fun : Cog {

    private val rpsOptions = arrayOf("rock", "paper", "scissors")

    @Command(description = "Rock, paper, scissors!")
    fun rps(ctx: Context, @Name("option") choice: String) {
        if (!rpsOptions.contains(choice)) {
            return ctx.send("You have to pick between `rock`, `paper` or `scissors` ;-;")
        }

        val selected = Helpers.chooseRandom(rpsOptions)

        if (choice == selected) {
            return ctx.send("It was a tie, no one wins...")
        } else if (choice == "rock") {
            if (selected == "paper") {
                ctx.send("You lose! \uD83D\uDCC4\n**$selected** covers **$choice**")
            } else {
                ctx.send("You win! ✊\n**$choice** smashes **$selected**")
            }
        } else if (choice == "paper") {
            if (selected == "scissors") {
                ctx.send("You lose! ✂\n**$selected** cut **$choice**")
            } else {
                ctx.send("You win! \uD83D\uDCC4\n**$choice** covers **$selected**")
            }
        } else if (choice == "scissors") {
            if (selected == "rock") {
                ctx.send("You lose! ✊\n**$selected** smashes **$choice**")
            } else {
                ctx.send("You win! ✂\n**$choice** cut **$selected**")
            }
        }
    }

}