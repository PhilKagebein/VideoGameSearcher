package com.example.gamestache.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.gamestache.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {

    private lateinit var favoritesViewModel: FavoritesViewModel
    private lateinit var binding: FragmentFavoritesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        favoritesViewModel = ViewModelProvider(this).get(FavoritesViewModel::class.java)

        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

}