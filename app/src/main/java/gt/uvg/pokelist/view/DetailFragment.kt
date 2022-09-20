package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.databinding.FragmentDetailBinding
import gt.uvg.pokelist.model.Pokemon
import gt.uvg.pokelist.repository.PokemonRepository
import kotlin.properties.Delegates

class DetailFragment : Fragment() {

    companion object {
        val IMAGEURLFRONT = "imageUrlFront"
        val IMAGEURLBACK = "imageUrlBack"
        val IMAGEURLSHINNYFRONT = "imageUrlShinnyFront"
        val IMAGEURLSHINNYBACK = "imageUrlShinnyBack"
    }

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!


    private lateinit var imageUrlFront: String
    private lateinit var imageUrlBack: String
    private lateinit var imageUrlShinnyFront: String
    private lateinit var imageUrlShinnyBack: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageUrlFront = it.getString(IMAGEURLFRONT).toString()
            imageUrlBack = it.getString(IMAGEURLBACK).toString()
            imageUrlShinnyFront = it.getString(IMAGEURLSHINNYFRONT).toString()
            imageUrlShinnyBack = it.getString(IMAGEURLSHINNYBACK).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Retrieve and inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Picasso.get().load(imageUrlFront).into(binding.imageView2);
        Picasso.get().load(imageUrlBack).into(binding.imageView3);
        Picasso.get().load(imageUrlShinnyFront).into(binding.imageView4);
        Picasso.get().load(imageUrlShinnyBack).into(binding.imageView5);
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}