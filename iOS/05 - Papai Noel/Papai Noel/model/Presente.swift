//
//  Presente.swift
//  Papai Noel
//
//  Created by Valéria Cavalcanti on 22/11/19.
//  Copyright © 2019 Valéria Cavalcanti. All rights reserved.
//

import Foundation

class Presente: NSObject {
    var descricao: String
    var grau: Int
    
    override var description: String{
        return "\(descricao) - \(grau)"
    }
    
    init(descricao: String, grau: Int){
        self.descricao = descricao
        self.grau = grau
    }
}
