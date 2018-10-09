import com.github.kittinunf.fuel.Fuel
import dbmodels.Songs
import models.favoriteSongs
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
//Javier Salazar
//Benjamin Izquierdo
fun main(args: Array<String>) {
    val url = "https://next.json-generator.com/api/json/get/EkeSgmXycS"
    val (request, response, result) = Fuel.get(url).responseObject(favoriteSongs.favoriteSongsArrayDeserializer())
    val (songs, err) = result
    //songs?.forEach{println(it)}

    Database.connect(
            "jdbc:postgresql:misctests",
            "org.postgresql.Driver",
            "postgres",
            "123"
    )
    print(menu());

    var optionMenu = readLine()

    if (optionMenu.equals("1")) {
        println("Write the song name")
        var songName: String? = readLine()
        var songFound: ArrayList<String> = findByName(songName, songs)

        for (i in 0..songFound.size - 1) {
            println(songFound.get(i))
        }

        if(songFound.size != 0) {
            println("Select the song")
            var selectedSong: Int = 0
            selectedSong = Integer.parseInt(readLine())

            println("Do you wish to select it as a favorite? ")
            var favoriteOption = readLine()

            if (favoriteOption?.toUpperCase().equals("YES")) {
                insertInToDataBase(songs, selectedSong)
                print("Song added to your favorite list\nPress enter to continue")
                readLine()
            } else {
                println("Song not added to the favorite list")
            }
        }else{
            println("Song doesn't exist\nPress Enter to continue")
            readLine()
        }


    }

    if (optionMenu.equals("2")) {
        println("Write the Artist Name")
        var artist: String? = readLine()
        var songFound: ArrayList<String> = findByArtist(artist, songs)

        for (i in 0..songFound.size - 1) {
            println(songFound.get(i))
        }

        if(songFound.size != 0) {


            println("Select the song")
            var selectedSong: Int = 0
            selectedSong = Integer.parseInt(readLine())

            println("Do you wish to select it as a favorite? ")
            var favoriteOption = readLine()

            if (favoriteOption?.toUpperCase().equals("YES")) {
                insertInToDataBase(songs, selectedSong)
                print("Song added to your favorite list\npress enter to continue")
                readLine()
            } else {
                println("Song not added to the favorite list")
            }
        }else{
            println("Artis does not exist\nPress Enter To continue")
            readLine()
        }

    }

    if (optionMenu.equals("3")) {
    try {
        transaction {

            for (book in Songs.selectAll()) {
                println("${book[Songs.id]}: ${book[Songs.song]}")
            }
            println("Press Enter to back to the main menu")
            readLine()
        }
    }catch (ex: Exception){
        println("Is Empty")
    }



    }
    if (optionMenu.equals("4")) {
            return
    }

    findByName("", songs)

    }


    fun menu(): String {
        return "Find songs by ......+" +
                "1.Name\n" +
                "2.Artist\n" +
                "3.Favorite Songs\n" +
                "4.Exit\n"
    }
    fun findByName(name: String?, songs: Array<favoriteSongs>?): ArrayList<String> {
        return ""
    }

    fun findByArtist(author: String?, songs: Array<favoriteSongs>?): ArrayList<String> {
        return ""
    }

    fun insertInToDataBase(songs: Array<favoriteSongs>?, selectedSong: Int): Unit {

    }


