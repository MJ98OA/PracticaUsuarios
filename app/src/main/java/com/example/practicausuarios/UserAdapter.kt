package com.example.practicausuarios

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicausuarios.databinding.UsuariosBinding


class UserAdapter(var listaUsuarios: List<Result>):RecyclerView.Adapter<UserAdapter.UsersViewHolder>(){

    lateinit var  context:Context

    class UsersViewHolder(var itemBinding: UsuariosBinding):RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val binding=UsuariosBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        context=parent.context
        return  UsersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.itemBinding.nombreUsuario.text=listaUsuarios[position].name.first
        holder.itemBinding.apellidoUsuario.text=listaUsuarios[position].name.last

        holder.itemBinding.layoutUsers.setOnClickListener {
            MainActivity.launch(
                holder.itemBinding.layoutUsers.context,listaUsuarios.get(position).toString()
            )
        }

    }

    override fun getItemCount(): Int {
        return  listaUsuarios.size
    }


}

