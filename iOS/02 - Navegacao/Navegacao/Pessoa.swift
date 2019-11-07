//
//  Pessoa.swift
//  Navegacao
//
//  Created by Valéria Cavalcanti on 07/11/19.
//  Copyright © 2019 Valéria Cavalcanti. All rights reserved.
//

import Foundation

class Pessoa: NSObject {
    var nome: String
    var idade: Int
    
    override var description: String{
        return "\(nome) - \(idade)"
    }
    
    init(nome: String, idade: Int){
        self.nome = nome
        self.idade = idade
    }
}
