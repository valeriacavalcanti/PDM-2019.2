//
//  AmigoSecreto.swift
//  Amigo Secreto
//
//  Created by Valéria Cavalcanti on 05/12/19.
//  Copyright © 2019 Valéria Cavalcanti. All rights reserved.
//

import Foundation

class Confra: NSObject {
    var amiguinho:String
    var descricao: String
    var valor: Float
    
    override var description: String{
        return self.amiguinho
    }
    
    init(amiguinho: String, descricao: String, valor: Float){
        self.amiguinho = amiguinho
        self.descricao = descricao
        self.valor = valor
    }
}
