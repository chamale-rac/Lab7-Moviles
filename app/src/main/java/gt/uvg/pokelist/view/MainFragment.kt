package gt.uvg.pokelist.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import gt.uvg.pokelist.databinding.FragmentMainBinding
import gt.uvg.pokelist.model.Pokemon
import gt.uvg.pokelist.repository.PokemonRepository
import gt.uvg.pokelist.repository.Repository
import gt.uvg.pokelist.utils.Constants

class MainFragment: Fragment() {
    private var _binding: FragmentMainBinding? = null

    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    private lateinit var viewModel: MainViewModel
    private var myResults: MutableList<Pokemon> = PokemonRepository().getPokemonList()
    private var getData = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
            myResults = response.results
            for (i in 0 until Constants.RETRIEVED) {
                myResults[i] = Pokemon(i+1, myResults[i].name)
            }
            Log.d("show", myResults.toString())
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView
        recyclerView.adapter = PokemonListAdapter(myResults)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}