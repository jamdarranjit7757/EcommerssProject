package com.example.waayu.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.waayu.data.product.Product
import com.example.waayu.databinding.FragmentCartBinding
import com.example.waayu.ui.adapter.CartAdapter
import com.example.waayu.ui.adapter.HistoryAdapter
import com.example.waayu.ui.adapter.ProductClickListener
import com.example.waayu.ui.adapter.RemoveProductListner
import com.example.waayu.ui.viewmodel.CartViewMode
import com.example.waayu.ui.viewmodel.HistoryViewMode
import com.example.waayu.utils.GlobalSnackBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment() {

    private lateinit var mBinding: FragmentCartBinding
    private lateinit var cartAdapter: CartAdapter
    private val mCartViewModel by viewModels<CartViewMode>()
    var layoutManager: LinearLayoutManager? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentCartBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        mBinding.rvCart.layoutManager = layoutManager
        setObserver()
        mCartViewModel.getCartList()
    }
    private fun setObserver() {
        mCartViewModel.responseGetCart.observe(viewLifecycleOwner){
            if (!it.isEmpty()){
                mBinding.tvempty.visibility =View.GONE
                mBinding.rvCart.visibility = View.VISIBLE
                mBinding.totalcart.visibility = View.VISIBLE
                cartAdapter = CartAdapter(requireContext(),it,
                    object : RemoveProductListner {
                        override fun onRemoveProductClick(product: Product) {
                            mCartViewModel.removeFromCart(product)
                        }
                    })
                mBinding.rvCart.adapter = cartAdapter
                mBinding.tvPrize.text = "Rs." +  " " + it.sumOf { it.price }.toString()
            }else{
                mBinding.rvCart.visibility = View.GONE
                mBinding.totalcart.visibility = View.GONE
                mBinding.tvempty.visibility =View.VISIBLE
            }

        }
        mCartViewModel.successData.observe(viewLifecycleOwner){
            mCartViewModel.getCartList()
            GlobalSnackBar.showSnackBar(
                mBinding.root,
                it,
                true
            )
        }
    }
}