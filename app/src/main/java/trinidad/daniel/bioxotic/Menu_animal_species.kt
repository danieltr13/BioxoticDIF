package trinidad.daniel.bioxotic

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_menu_animal_species.*
import kotlinx.android.synthetic.main.item_species.view.*
import trinidad.daniel.bioxotic.entities.Specie

class Menu_animal_species : AppCompatActivity() {
    var species = ArrayList<Specie>()

    var adapter: SpeciesAdapter ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_animal_species)

        val lv_species: ListView = findViewById(R.id.lv_species)

        loadSpecies()

        adapter = SpeciesAdapter(this, species)
        lv_species.adapter = adapter

        val ib_back_menu_species: ImageButton = findViewById(R.id.ib_back_menu_species)
        ib_back_menu_species.setOnClickListener{
            var signInIntent: Intent? = Intent(this, Menu_species::class.java)
            startActivity(signInIntent)
        }
    }

    fun loadSpecies() {
        species.add(Specie(R.drawable.axolotlcsquare, "Axolotl", "The correct maintenance of axolotls is summarized in the quality of the water, temperature, filtering and lighting. \\n \\nThey are considered strict carnivores in free life and feed on small crustaceans, fish, larvae of other insects, copepods and microorganisms."))
        species.add(Specie(R.drawable.axolotlcsquare, "Axolotl", "The correct maintenance of axolotls is summarized in the quality of the water, temperature, filtering and lighting. \\n \\nThey are considered strict carnivores in free life and feed on small crustaceans, fish, larvae of other insects, copepods and microorganisms."))
        species.add(Specie(R.drawable.axolotlcsquare, "Axolotl", "The correct maintenance of axolotls is summarized in the quality of the water, temperature, filtering and lighting. \\n \\nThey are considered strict carnivores in free life and feed on small crustaceans, fish, larvae of other insects, copepods and microorganisms."))
        species.add(Specie(R.drawable.axolotlcsquare, "Axolotl", "The correct maintenance of axolotls is summarized in the quality of the water, temperature, filtering and lighting. \\n \\nThey are considered strict carnivores in free life and feed on small crustaceans, fish, larvae of other insects, copepods and microorganisms."))
        // Aqui van mas :D
    }
}


class SpeciesAdapter : BaseAdapter {
    var species = ArrayList<Specie>()
    var context: Context? = null

    constructor(context: Context, species:ArrayList<Specie>){
        this.context = context
        this.species = species
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var  specie = species[position]
        var inflador = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = inflador.inflate(R.layout.item_species, null) as View
        view.tv_name_specie.setText(specie.name)
        view.iv_image_specie.setImageResource(specie.image)

        view.btn_see_more.setOnClickListener {
            var intent = Intent(context, Animal_description::class.java)
            intent.putExtra("image", specie.image)
            intent.putExtra("name", specie.name)
            intent.putExtra("description", specie.description)
            context!!.startActivity(intent)
        }

        return view
    }

    override fun getItem(position: Int): Any {
        return species[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return species.size
    }
}